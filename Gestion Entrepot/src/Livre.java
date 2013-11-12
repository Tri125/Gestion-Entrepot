
public class Livre extends Produit
{

	private String auteur;
	private String titre;
	
	public String getAuteur()
	{
		return auteur;
	}
	
	public String getTitre()
	{
		return titre;
	}
	
	/**
	 * Constructeur d'un livre
	 * 
	 * @param code  code unique d'identification d'un produit (<code>String</code>)
	 * @param quantite nombre d'unités de produit dans l'entrepôt (<code>int</code>) 
	 * @param prix  prix unitaire (<code>double</code>)
	 * @param auteur auteur du livre (<code>String</code>)
	 * @param titre titre du livre (<code>String</code>)
	 */
	public Livre(String code, int quantite, double prix, String auteur, String titre) {
		super(code, quantite, prix);
		this.auteur = auteur;
		this.titre = titre;
	}
	
	public Livre(String codeS,String quantiteS, String prixS, String auteurS, String titreS) throws NumberFormatException {
		this(codeS,Integer.parseInt(quantiteS),Double.parseDouble(prixS), auteurS, titreS);
	}
	
	
	@Override
	public String toString() {
		return (super.toString() + ";" + auteur + ";" + titre);
	}

}
