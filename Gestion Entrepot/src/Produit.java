/**
 * Classe abstraite qui définit la structure générale d'un produit
 * qui apparaît dans l'entrepôt. Tout produit devrait hériter de cette classe
 * 
 * @author Guy Lapalme, Université de Montréal, 2013
 *
 */
public abstract class Produit {
	private String code;
	private int quantite;
	private double prix;
	
	/**
	 * Constructeur d'un produit 
	 * 
	 * @param code  code unique d'identification d'un produit (<code>String</code>)
	 * @param quantite nombre d'unités de produit dans l'entrepôt (<code>int</code>) 
	 * @param prix  prix unitaire (<code>double</code>)
	 */
	public Produit(String code,int quantite,double prix) {
		this.code = code;
		this.quantite = quantite;
		this.prix = prix;
	}

	public Produit(String codeS,String quantiteS, String prixS) throws NumberFormatException {
		this(codeS,Integer.parseInt(quantiteS),Double.parseDouble(prixS));
	}
	
	@Override
	public String toString() {
		return code+";"+quantite+";"+prix;
	}
		
	@Override
	public int hashCode() {
		return code.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (!(obj instanceof Produit))return false;
		return code.equals(((Produit)obj).code);
	}

	/**
	 * @return le code du produit
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return la quantité actuelle de produit
	 */
	public int getQuantite(){
		return quantite;
	}
	
	/**
	 * @return le prix unitaire
	 */
	public double getPrix(){
		return prix;
	}
	
	/**
	 * Ajoute n unités de produit à la quantité dans l'entrepôt, si l'ajout (qui
	 * peut être négative) ferait en sorte que la quantité devienne négative, on 
	 * ne change pas la quantité et on retourne <code>false</code> 
	 * @param n nombre d'unités à ajouter
	 * @return <code>true</code> si la quantité a été changée, <code>falsee</code> sinon
	 */
	public boolean ajouter(int n){
		int q1=quantite+n;
		if(q1>=0){
			quantite=q1;
			return true;
		}
		return false;
	}
	
	/**
	 * Enlève n unités de produit à la quantité dans l'entrepôt, si la quantité 
	 * devenait négative, la quantité n'est pas changée et on retourne <code>false</code>
	 * @param n nombre d'unités à enlever
	 * @return <code>true</code> si la quantité a été changée, <code>falsee</code> sinon
	 */
	public boolean enlever(int n){
		return ajouter(-n);
	}
}
