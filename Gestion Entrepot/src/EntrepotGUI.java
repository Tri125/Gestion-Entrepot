import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
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
		
		JLabel lbCode = new JLabel("Code");
		JTextField txtCode = new JTextField(5);
		
		JLabel lbNom = new JLabel("Nom");
		JTextField txtNom = new JTextField(10);
		
		JLabel lbAdresse = new JLabel("Adresse");
		JTextField txtAdresse = new JTextField(20);
		
		JLabel lbQuantite = new JLabel("Quantité");
		JTextField txtQuantite = new JTextField(3);
		
		JTextArea txtOutput = new JTextArea("teste");
		//txtOutput.setEditable(false);
		txtOutput.setLineWrap( true );
		txtOutput.setWrapStyleWord( true );
		
		JComboBox<String> selectionProduit = new JComboBox<String>(produits);
		
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
		
		panel.add(lbCode);
		panel.add(txtCode);
		
		panel.add(lbNom);
		panel.add(txtNom);
		
		panel.add(lbAdresse);
		panel.add(txtAdresse);
		
		panel.add(lbQuantite);
		panel.add(txtQuantite);
		
		panel.add(txtOutput);
	}

}
