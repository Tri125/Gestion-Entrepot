import java.util.ArrayList;
import java.util.List;

/**
 * Structure correspondant à un client défini par son nom et son adresse
 * 
 * @author Guy Lapalme, Université de Montréal, 2013
 *
 */
public class Client {
	private String nom;
	private String adresse;
	private List<Commande> commandes; // commande passées par ce client
	
	/**
	 * Création d'un client 
	 * 
	 * @param nom <code>String</code> (sert d'identification unique)
	 * @param adresse <code>String</code>
	 */
	public Client(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
		commandes = new ArrayList<Commande>();
	}

	@Override
	public int hashCode() {
		return nom.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (! (obj instanceof Client)) return false;
		return nom.equals(((Client)obj).nom);
	}

	@Override
	public String toString() {
		return "Client;"+nom + ";" + adresse;
	}

    /**
	 * @return nom du client
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return adresse du client
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return toutes les commandes d'un client
	 */
	public List<Commande> getCommandes() {
		return commandes;
	}
}
