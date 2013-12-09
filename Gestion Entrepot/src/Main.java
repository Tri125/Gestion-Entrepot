import javax.swing.JFrame;


public class Main {
	
	public static void main(String[] args) {
		
		final String NOM_FICHIER = "entrepot.txt";
		
		// TODO Auto-generated method stub
		Entrepot entrepot = new Entrepot(NOM_FICHIER);
		EntrepotGUI gui = new EntrepotGUI(entrepot);
		gui.setVisible(true);
		gui.setSize(800, 600);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
