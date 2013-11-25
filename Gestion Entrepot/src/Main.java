import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entrepot entrepot = new Entrepot("entrepot.txt");
		EntrepotGUI gui = new EntrepotGUI(entrepot);
		gui.setVisible(true);
		gui.setSize(800, 600);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
