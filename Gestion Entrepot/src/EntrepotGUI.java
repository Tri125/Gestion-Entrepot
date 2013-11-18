import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.setTitle("Gestion Entrepot");
		panel.setVisible(true);
		this.add(panel);
		Initialisation();
	}
	
	private void Initialisation()
	{
		panel.add(new Options());
		JTextArea txtOutput = new JTextArea();
		txtOutput.setSize(this.getWidth(), this.getHeight()/2);
		txtOutput.setEditable(false);
		txtOutput.setLineWrap( true );
		txtOutput.setWrapStyleWord( true );
		JScrollPane scroll = new JScrollPane (txtOutput, 
				   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scroll);
	}
	
	
	private class Options extends JPanel
	{
		public Options()
		{
			super();
			
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
			
			JComboBox<String> selectionProduit = new JComboBox<String>(produits);
			
			ButtonGroup group = new ButtonGroup();
			group.add(ajouter);
			group.add(enlever);
			group.add(commander);
			
			
			this.add(selectionProduit);
			this.add(ajouter);
			this.add(enlever);
			this.add(commander);
			this.add(ok);
			this.add(lister);
			
			this.add(lbCode);
			this.add(txtCode);
			
			this.add(lbNom);
			this.add(txtNom);
			
			this.add(lbAdresse);
			this.add(txtAdresse);
			
			this.add(lbQuantite);
			this.add(txtQuantite);
			
		}
	}
	

}
