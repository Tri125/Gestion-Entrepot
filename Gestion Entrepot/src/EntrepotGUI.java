import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class EntrepotGUI extends JFrame
{
	private Entrepot entrepot;
	private JPanel panel;
	
	public EntrepotGUI()
	{
		super();
		panel = new JPanel();
		this.setTitle("Gestion Entrepot");
		panel.setVisible(true);
		this.add(panel);
		Initialisation();
	}
	
	private void Initialisation()
	{
		String[] produits = { "Livre", "Ordinateur" };
		JRadioButton ajouter = new JRadioButton("Ajouter");
		JRadioButton enlever = new JRadioButton("Enlever");
		JRadioButton commander = new JRadioButton("Commander");
		JButton ok = new JButton("OK");
		JButton lister = new JButton("Lister");
		JTextField code = new JTextField(1);
		JTextField nom = new JTextField(1);
		JTextField adresse = new JTextField(1);
		JTextField quantite = new JTextField(1);
		code.add(new JLabel("Code"));

		JComboBox selectionProduit = new JComboBox(produits);
		
		ButtonGroup group = new ButtonGroup();
		group.add(ajouter);
		group.add(enlever);
		group.add(commander);
		
		
		panel.add(selectionProduit);
		panel.add(ajouter);
		panel.add(enlever);
		panel.add(commander);
		panel.add(ok);
		panel.add(lister);
		
		//panel.add(code);
		//panel.add(nom);
		//panel.add(adresse);
		//panel.add(quantite);
		
	}

}
