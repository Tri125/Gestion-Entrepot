import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Un commande définie par une date, qui indique le produit, le client et la quantité commandée
 * 
 * @author Guy Lapalme, Université de Montréal, 2013
 *
 */
public class Commande {
	private Date date;
	private Produit produit;
	private Client client;
	private int quantite;
	
	private static SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/**
	 * Constructeur de Commande 
	 * @param date de la commande
	 * @param produit lien sur le produit commandé
	 * @param client lien sur le client
	 * @param quantite de la commande
	 */
	Commande(Date date, Produit produit, Client client, int quantite) {
		this.date = date;
		this.produit = produit;
		this.client = client;
		this.quantite = quantite;
		client.getCommandes().add(this);
	}

	/**
	 * Création d'une Commande à partir de  <code>String</code>, de clients et des produits
	 *  
	 * @param fields tableau de <code>String</code> devrait contenir 5 éléments
	 */
     Commande(String dateS,Produit p, Client c, String quantiteS) throws NumberFormatException, ParseException{
		this(fmt.parse(dateS),p,c,Integer.parseInt(quantiteS));
	}
	
	@Override
	public String toString() {
		return "Commande;" + fmt.format(date) + ";" + produit.getCode() + ";"
				+ client.getNom() + ";" + quantite;
	}
	
	/**
	 * @return la date de la commande
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return le produit commandé
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @return le client qui a commandé
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return la quantité commandée
	 */
	public int getQuantite() {
		return quantite;
	}
}
