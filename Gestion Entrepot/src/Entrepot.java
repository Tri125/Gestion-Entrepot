import java.util.Date;
import java.util.List;
import java.util.SortedMap;


public class Entrepot 
{
	private LecteurEntrepot lecteurDonne;
	
	private List<Commande> commandes;
	private SortedMap<String, Client> clients;
	private SortedMap<String, Produit> produits;
	
	public Entrepot()
	{
		lecteurDonne = new LecteurEntrepot();
	}
	
	
	public Entrepot(String fichier)
	{
		lecteurDonne = new LecteurEntrepot();
		ChargementDonne(fichier);
	}
	
	
	
	private void ChargementDonne(String fichier)
	{
		if (lecteurDonne != null)
		{
			lecteurDonne.LectureFichier(fichier);
			if (lecteurDonne.getisInitialized())
			{
				commandes = lecteurDonne.getCommandes();
				clients = lecteurDonne.getClients();
				produits = lecteurDonne.getProduits();
			}
			else
			{
				System.out.println("Entrepot::ChargementDonne : Erreur initialisation, aucune donnée chargé.");
			}
		}
	}
	
	
	public void RajoutInventaire(String code, int quantite)
	{
		if (quantite <= 0)
		{
			System.out.println("Erreur PEBCAK");
			return;
		}
		if(produits.containsKey(code))
		{
			produits.get(code).ajouter(quantite);
		}
		else
		{
			System.out.println("Aucun produit correspond au code.");
		}
	}
	
	
	
	public void EnleverQuantite(String code, int quantite)
	{
		if (quantite >= 0)
		{
			System.out.println("Erreur PEBCAK");
			return;
		}
		if(produits.containsKey(code))
		{
			produits.get(code).enlever(quantite);
		}
		else
		{
			System.out.println("Aucun produit correspond au code.");
		}
		
	}
	
	public void Commander(String codeProduit, int quantite, String nomClient, String adresse)
	{
		if (quantite <= 0)
		{
			System.out.println("Erreur PEBCAK");
			return;
		}
		Client clientTmp;
		Produit produitTmp;
		Commande cmdTmp;
		
		//Vérifie si le produit existe à partir du code
		if (produits.containsKey(codeProduit))
		{
			produitTmp = produits.get(codeProduit);
			if (produitTmp.getQuantite() == 0)
			{
				System.out.println("Produit en rupture de stock.");
				return;
			}
		}
		else
		{
			System.out.println("Aucun produit correspond au code.");
			return;
		}
		
		//Vérifie si le client existe déjà dans nos données
		if (clients.containsKey(nomClient) )
		{
			clientTmp = clients.get(nomClient);
		}
		else
		{
			//Sinon on rajoute un nouveau client dans la map
			clientTmp = new Client (nomClient, adresse);
			clients.put(nomClient, clientTmp);
		}
		
		//Si nous pouvons commander la quantite demandé, nous procédons à la commande
		if (produits.get(codeProduit).enlever(quantite))
		{
			//Création d'une nouvelle commande
			cmdTmp = new Commande (new Date(), produitTmp, clientTmp, quantite);
			clientTmp.getCommandes().add(cmdTmp);
			commandes.add(cmdTmp);
		}
		
	}
	
	
	public void ListerProduits()
	{
		for (Produit p : produits.values())
		{
			System.out.println(p.toString());
		}
	}
	
	public void ListerCommandes()
	{
		for (Commande c : commandes)
		{
			System.out.println(c.toString());
		}
	}
	
	public void ListerClients()
	{
		for (Client c : clients.values())
		{
			System.out.println(c.toString());
		}
	}
	
	
//	public void RetirerProduit(String code)
//	{
//		if (produits.containsKey(code))
//		{
//			produits.remove(code);
//		}
//		else
//		{
//			System.out.println("Aucun produit correspond au code.");
//		}
//	}
	
	
//	public void NouveauLivre(String codeS,String quantiteS, String prixS, String auteurS, String titreS)
//	{
//		Produit tmp = new Livre (codeS,quantiteS, prixS, auteurS, titreS);
//	}
	
	
	

}
