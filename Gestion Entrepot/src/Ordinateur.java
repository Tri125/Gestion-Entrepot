
public class Ordinateur extends Produit 
{
	
	private String marque;
	
	public String getMarque()
	{
		return marque;
	}
	
	
	/**
	 * Constructeur d'un ordinateur
	 * 
	 * @param code  code unique d'identification d'un produit (<code>String</code>)
	 * @param quantite nombre d'unités de produit dans l'entrepôt (<code>int</code>) 
	 * @param prix  prix unitaire (<code>double</code>)
	 * @param marque marque de l'ordinateur (<code>String</code>)
	 */
	public Ordinateur(String code, int quantite, double prix, String marque) {
		super(code, quantite, prix);
		this.marque = marque;
	}
	
	public Ordinateur(String codeS,String quantiteS, String prixS, String marqueS) throws NumberFormatException {
		this(codeS,Integer.parseInt(quantiteS),Double.parseDouble(prixS), marqueS);
	}
	
	
	
	@Override
	public String toString() {
		return (super.toString() + ";" + marque);
	}
}
