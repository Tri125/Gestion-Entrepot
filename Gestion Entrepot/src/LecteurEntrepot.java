import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LecteurEntrepot 
{
	private final char DELIMITATION_CHAMPS = ';';
	
	private boolean isInitialized = false;
	private BufferedReader in = null;
	private String dernierFichierLut;
	private final List<String> objetSupporte;
	
	
	private Map<String, List<Commande> > commandes2;
	private Map<String, Produit> produits2;
	
	private List<Commande> commandes;
	private Set<Client> clients;
	private Set<Produit> produits;
	
	public LecteurEntrepot()
	{
		produits2 = new HashMap<String, Produit>(5);
		commandes2 = new HashMap<String, List<Commande> >(4);
		
		commandes = new ArrayList<Commande>();
		clients   = new HashSet<Client>();
		produits  = new HashSet<Produit>();
		
		objetSupporte = new ArrayList<String>(4);
		objetSupporte.add("Livre");
		objetSupporte.add("Ordinateur");
		objetSupporte.add("Client");
		objetSupporte.add("Commande");
	}
	
	
	public void LectureFichier(String chemin)
	{
		try 
		{
			String ligne;
			in = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF-8"));
			
			while ( (ligne = in.readLine()) != null)
			{
				ligne = ligne.trim();
				
				if(ligne.isEmpty() || ligne.charAt(0) == '#' || ligne.length() == 1)
				{
					//Continue
				}
				else
				{
					Instantiation (TraitementLigne(ligne));
				}
				
			}
			in.close();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
			//sup = null;
		}
		
		finally
		{
			dernierFichierLut = chemin;
		}
	
	}
	
	private List<String> TraitementLigne(String ligne)
	{
		List<String> ligneTraite = new ArrayList<String>();
		int index;
		String subLigne = ligne;
		
		while ( (index = subLigne.indexOf(DELIMITATION_CHAMPS) ) != -1)
		{
			String tmp = subLigne.substring(0, index);
			subLigne = subLigne.substring(index+1);
			
			ligneTraite.add(tmp);
		}
		
		ligneTraite.add(subLigne);
		
		return ligneTraite;
		
	}

	private void Instantiation(List<String> ligne)
	{
		
		if ( ligne.get(0).equals(objetSupporte.get(0))  && ligne.size() == 6)
		{
			produits.add(new Livre(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
			if (produits2.containsKey(ligne.get(1)))
			{
				System.out.print("LecteurEntrepot::Instantiation : Duplication du code produit." + ligne.get(1));
				return;
			}
			produits2.put(ligne.get(1), new Livre(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
		}
		else
			if ( ligne.get(0).equals(objetSupporte.get(1)) && ligne.size() == 6)
			{
				produits.add(new Ordinateur(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
				if (produits2.containsKey(ligne.get(1)))
				{
					System.out.print("LecteurEntrepot::Instantiation : Duplication du code produit" + ligne.get(1));
					return;
				}
				produits2.put(ligne.get(1), new Ordinateur(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
			}
			else
				if ( ligne.get(0).equals(objetSupporte.get(2)) && ligne.size() == 3)
				{
					clients.add(new Client(ligne.get(1), ligne.get(2)));
				}
				else
					if ( ligne.get(0).equals(objetSupporte.get(3) ) && ligne.size() == 5)
					{
						Client clientTmp = null;
						Produit produitTmp = null;
						
						for (Client c: clients)
						{
							if (ligne.get(3).equals(c.getNom()))
							{
								clientTmp = c;
								break;
							}
						}
						
						for (Produit p : produits)
						{
							if (ligne.get(2).equals(p.getCode()))
							{
								produitTmp = p;
								break;
							}
						}
						
						if (clientTmp == null)
							System.out.println("LecteurEntrepot::Instantiation : Client de la commande introuvable");	
						if (produitTmp == null)
							System.out.println("LecteurEntrepot::Instantiation : Produit de la commande introuvable");
						
						try 
						{
							commandes.add(new Commande(ligne.get(1), produitTmp, clientTmp, ligne.get(4)));
						} 
						catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("LecteurEntrepot::Instantiation : Erreur, type de l'objet non reconnue");
						System.out.println(ligne);
					}
			
		
		
		
	}
	

}
