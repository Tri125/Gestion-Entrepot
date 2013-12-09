import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class LecteurEntrepot 
{
	private final char DELIMITATION_CHAMPS = ';';
	
	private boolean isInitialized = false;
	private BufferedReader in = null;
	private String dernierFichierLut = null;
	private final List<String> objetSupporte;
	
	
	private SortedMap<String, Produit> produits;
	
	private List<Commande> commandes;
	private SortedMap<String, Client> clients;
	
	
	public String getDernierFichierLut()
	{
		return dernierFichierLut;
	}
	
	public boolean getisInitialized()
	{
		return isInitialized;
	}
	
	public SortedMap<String, Produit> getProduits()
	{
		return produits;
	}
	
	public List<Commande> getCommandes()
	{
		return commandes;
	}
	
	public SortedMap<String, Client> getClients()
	{
		return clients;
	}
	
	

	
	
	public LecteurEntrepot()
	{
		produits = new TreeMap<String, Produit>();
		
		commandes = new ArrayList<Commande>();
		clients   = new TreeMap<String, Client>();
		
		objetSupporte = new ArrayList<String>(4);
		objetSupporte.add("Livre");
		objetSupporte.add("Ordinateur");
		objetSupporte.add("Client");
		objetSupporte.add("Commande");
	}
	
	
	
	public LecteurEntrepot(String fichier)
	{
		this();	
		LectureFichier(fichier);
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
			isInitialized = true;
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
			isInitialized = false;
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
	
	
	public void Sauvegarde(String chemin, SortedMap<String, Produit> produits, SortedMap<String, Client> clients, List<Commande> commandes)
	{
		BufferedWriter writer = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		try
		{
			 writer = new BufferedWriter(new FileWriter(chemin));
			 Collection<Produit> colProduit = produits.values();
			 for (Produit p : colProduit)
			 {
				 if (p instanceof Livre)
				 {
					 Livre tmp = (Livre)p;
					 writer.write("Livre;" + tmp.getCode() + ";" + tmp.getQuantite() + ";" + tmp.getPrix() + ";" + tmp.getAuteur() + ";" + tmp.getTitre());
					 writer.write("\n");
				 }
				 else
					 if (p instanceof Ordinateur)
					 {
						 Ordinateur tmp = (Ordinateur)p;
						 writer.write("Ordinateur;" + tmp.getCode() + ";" + tmp.getQuantite() + ";" + tmp.getPrix() + ";" + tmp.getMarque() + ";" + tmp.getCapaciteStockage());
						 writer.write("\n");
					 }
					 else
					 {
						 System.out.println("Erreur: Type produit inconnue");
						 writer.close();
						 return;
					 }
			 }
			 
			 Collection<Client> colClient = clients.values();
			 for (Client c : colClient)
			 {
				 writer.write("Client;" + c.getNom() + ";" + c.getAdresse());
				 writer.write("\n");
			 }
			 
			 for (Commande com : commandes)
			 {
				 writer.write("Commande;" + fmt.format(com.getDate()) + ";" + com.getProduit().getCode() + ";" + com.getClient().getNom() + ";" + com.getQuantite());
				 writer.write("\n");
			 }
			 
			 
		}
		catch (Exception e) 
		{
            e.printStackTrace();
		}
		finally 
		{
            try 
            {
                writer.close();
            } 
            catch (Exception e) 
            {
            	e.printStackTrace();
            }
        }
	}
	
//	private boolean TypeSupporter(String type)
//	{
//		for (String tmp : objetSupporte)
//		{
//			if (tmp.equals(type))
//				return true;
//		}
//		return false;
//	}

	private void Instantiation(List<String> ligne)
	{
		
		if ( ligne.get(0).equals(objetSupporte.get(0))  && ligne.size() == 6)
		{
			if (produits.containsKey(ligne.get(1)))
			{
				System.out.print("LecteurEntrepot::Instantiation : Duplication du code produit." + ligne.get(1));
				return;
			}
			produits.put(ligne.get(1), new Livre(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
		}
		else
			if ( ligne.get(0).equals(objetSupporte.get(1)) && ligne.size() == 6)
			{
				if (produits.containsKey(ligne.get(1)))
				{
					System.out.print("LecteurEntrepot::Instantiation : Duplication du code produit" + ligne.get(1));
					return;
				}
				produits.put(ligne.get(1), new Ordinateur(ligne.get(1), ligne.get(2), ligne.get(3), ligne.get(4), ligne.get(5)));
			}
			else
				if ( ligne.get(0).equals(objetSupporte.get(2)) && ligne.size() == 3)
				{
					clients.put(ligne.get(1), new Client(ligne.get(1), ligne.get(2)));
				}
				else
					if ( ligne.get(0).equals(objetSupporte.get(3) ) && ligne.size() == 5)
					{
						Client clientTmp = null;
						Produit produitTmp = null;
						
						if (clients.containsKey(ligne.get(3)))
						{
							clientTmp = clients.get(ligne.get(3));
						}
						
						
						if (produits.containsKey(ligne.get(2)))
						{
							produitTmp = produits.get(ligne.get(2));
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
