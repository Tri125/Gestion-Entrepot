import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

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
	
	public EntrepotGUI(Entrepot e)
	{
		super();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));		
		this.setTitle("Gestion Entrepot");
		panel.setVisible(true);
		this.add(panel);
		entrepot = e;
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
	
	
	private class Options extends JPanel implements ItemListener, ActionListener
	{
		final String AJOUTER = "Ajouter";
		final String ENLEVER = "Enlever";
		//final String RAJOUTER = "Rajouter Unite";
		final String COMMANDER = "Commander";
		
		String[] produits = { "Livre", "Ordinateur" };
		String[] comboBoxItems = { AJOUTER, ENLEVER,COMMANDER};
		//String[] comboBoxItems = { AJOUTER, ENLEVER,RAJOUTER,COMMANDER};
		
		JComboBox selectionProduit = new JComboBox(produits);
		JComboBox cb = new JComboBox(comboBoxItems);
		JPanel cards = new JPanel(new CardLayout());
		
		HashMap<String,JTextField> entreesAjoutLivre = new HashMap<String,JTextField>();
		HashMap<String,JTextField> entreesAjoutOrdi = new HashMap<String,JTextField>();
		HashMap<String,JTextField> entreesRajouter = new HashMap<String,JTextField>();
		HashMap<String,JTextField> entreesEnlever = new HashMap<String,JTextField>();
		HashMap<String,JTextField> entreesCommande = new HashMap<String,JTextField>();
		
		public Options()
		{
			super();
		    
			JButton ok = new JButton("OK");
			ok.addActionListener(this);
			
			JButton lister = new JButton("Lister");
			
			selectionProduit.addItemListener(this);	
			cb.addItemListener(this);
			
			this.add(selectionProduit);
			
			this.add(cb);
			this.add(ok);
			this.add(lister);
			
			cards.add(CardAjouterLivre(),"AJOUTERLIVRE");
			cards.add(CardAjouterOrdi(),"AJOUTERORDI");
			cards.add(CardCommande(),COMMANDER);
			cards.add(CardEnlever(),ENLEVER);
			//cards.add(CardRajouter(),RAJOUTER);
			
			this.add(cards);
		}
		private JPanel CardCommande(){

			JPanel card = new JPanel();
			
			JLabel lbCode = new JLabel("Code");
			JTextField txtCode = new JTextField(5);
			
			JLabel lbNom = new JLabel("Nom");
			JTextField txtNom = new JTextField(10);
			
			JLabel lbAdresse = new JLabel("Adresse");
			JTextField txtAdresse = new JTextField(20);
			
			JLabel lbQuantite = new JLabel("Quantite");
			JTextField txtQuantite = new JTextField(3);
			
			card.add(lbCode);
			card.add(txtCode);
			entreesCommande.put("Code", txtCode);
			
			card.add(lbNom);
			card.add(txtNom);
			entreesCommande.put("Nom", txtNom);
			
			card.add(lbAdresse);
			card.add(txtAdresse);
			entreesCommande.put("Adresse", txtAdresse);
			
			card.add(lbQuantite);
			card.add(txtQuantite);
			entreesCommande.put("Quantite", txtQuantite);
			return card;
		}

		private JPanel CardEnlever(){
			JPanel card = new JPanel();
			
			JLabel lbCode = new JLabel("Code");
			JTextField txtCode = new JTextField(5);
			
//			JLabel lbQuantite = new JLabel("Quantite");
//			JTextField txtQuantite = new JTextField(3);
					
			card.add(lbCode);
			card.add(txtCode);
			entreesEnlever.put("Code", txtCode);
//			
//			card.add(lbQuantite);
//			card.add(txtQuantite);
//			entreesEnlever.put("Quantite", txtQuantite);
			
			return card;
		}
	
		private JPanel CardRajouter(){
			JPanel card = new JPanel();
			
			JLabel lbCode = new JLabel("Code");
			JTextField txtCode = new JTextField(5);
			
			JLabel lbQuantite = new JLabel("Quantite");
			JTextField txtQuantite = new JTextField(3);
			
			card.add(lbCode);
			card.add(txtCode);
			entreesRajouter.put("Code", txtCode);
			
			card.add(lbQuantite);
			card.add(txtQuantite);
			entreesRajouter.put("Quantite", txtQuantite);
			return card;
		}
	
		private JPanel CardAjouterOrdi(){
			JPanel card = new JPanel();
			
			JLabel lbCode = new JLabel("Code");
			JTextField txtCode = new JTextField(5);
			
			JLabel lbMarque = new JLabel("Marque");
			JTextField txtMarque = new JTextField(10);
			
			JLabel lbQuantite = new JLabel("Quantite");
			JTextField txtQuantite = new JTextField(3);
			
			JLabel lbPrix= new JLabel("Prix");
			JTextField txtPrix = new JTextField(5);
			
			JLabel lbCapacite= new JLabel("Capacite");
			JTextField txtCapacite = new JTextField(3);
			
			card.add(lbCode);
			card.add(txtCode);
			entreesAjoutOrdi.put("Code", txtCode);
			
			card.add(lbMarque);
			card.add(txtMarque);
			entreesAjoutOrdi.put("Marque", txtMarque);
			
			card.add(lbPrix);
			card.add(txtPrix);
			entreesAjoutOrdi.put("Prix", txtPrix);
			
			card.add(lbCapacite);
			card.add(txtCapacite);
			entreesAjoutOrdi.put("Capacite", txtCapacite);
			
			card.add(lbQuantite);
			card.add(txtQuantite);
			entreesAjoutOrdi.put("Quantite", txtQuantite);
			return card;
		}
		private JPanel CardAjouterLivre(){
			JPanel card = new JPanel();
			
			JLabel lbCode = new JLabel("Code");
			JTextField txtCode = new JTextField(5);
			
			JLabel lbTitre = new JLabel("Titre");
			JTextField txtTitre = new JTextField(10);
			
			JLabel lbQuantite = new JLabel("Quantite");
			JTextField txtQuantite = new JTextField(3);
			
			JLabel lbPrix= new JLabel("Prix");
			JTextField txtPrix = new JTextField(5);
			
			JLabel lbAuteur= new JLabel("Auteur");
			JTextField txtAuteur = new JTextField(20);
			
			card.add(lbCode);
			card.add(txtCode);
			entreesAjoutLivre.put("Code", txtCode);
			
			card.add(lbTitre);
			card.add(txtTitre);
			entreesAjoutLivre.put("Titre", txtTitre);
			
			
			card.add(lbPrix);
			card.add(txtPrix);
			entreesAjoutLivre.put("Prix", txtPrix);
			
			card.add(lbAuteur);
			card.add(txtAuteur);
			entreesAjoutLivre.put("Auteur", txtAuteur);
			
			card.add(lbQuantite);
			card.add(txtQuantite);
			entreesAjoutLivre.put("Quantite", txtQuantite);
			return card;
		}
		private boolean NullEntrees(HashMap<String,JTextField> map) { 
			for(JTextField tf:map.values())
				if(tf.getText().isEmpty()){return true;}
			return false;
		}
		
		public void itemStateChanged(ItemEvent evt) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        if(this.cb.getSelectedItem() == AJOUTER)
	        {
	        	if(this.selectionProduit.getSelectedItem() == "Livre")
	        		cl.show(cards, "AJOUTERLIVRE");
	        	else
	        		cl.show(cards, "AJOUTERORDI");
	        }else     		
	        	cl.show(cards, (String)evt.getItem());
	    }
		//Problème de saisie des JTextFields NullPointerException
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object ItemSelect = this.cb.getSelectedItem();
			if(ItemSelect == AJOUTER)
	        {
	        	if(this.selectionProduit.getSelectedItem() == "Livre"){
	        		if(!NullEntrees(entreesAjoutLivre))
	        			entrepot.NouveauLivre(entreesAjoutLivre.get("Code").getText(),
	        					              entreesAjoutLivre.get("Quantite").getText(),
	        					              entreesAjoutLivre.get("Prix").getText(),
	        					              entreesAjoutLivre.get("Auteur").getText(),
	        					              entreesAjoutLivre.get("Titre").getText());
	        		for(JTextField tf: entreesAjoutLivre.values()){
	    				tf.setText(null);
	    			}
	        	}
	        	else{
	        		if(this.selectionProduit.getSelectedItem() == "Ordinateur" && !NullEntrees(entreesAjoutOrdi))
	        			entrepot.NouveauOrdi(entreesAjoutOrdi.get("Code").getText(),
								             entreesAjoutOrdi.get("Quantite").getText(),
					                         entreesAjoutOrdi.get("Prix").getText(),
	        								 entreesAjoutOrdi.get("Marque").getText(), 
	        								 entreesAjoutOrdi.get("Capacite").getText());
	        		for(JTextField tf: entreesAjoutOrdi.values()){
	        			tf.setText("");
	        		}
	        	}
	        }else{
	        	if(ItemSelect == ENLEVER){
	        		if(!NullEntrees(entreesEnlever))
	        			entrepot.RetirerProduit(entreesEnlever.get("CodeEnlever").getText());
	        		for(JTextField tf: entreesAjoutOrdi.values()){
	        			tf.setText(null);
	        		}
	        	}
//	        	else
//	        		if(ItemSelect == RAJOUTER){
//	        			if(!NullEntrees(entreesRajouter))
//	        				entrepot.RajoutInventaire(entreesRajouter.get("CodeRajout").getText(),
//	        										entreesRajouter.get("QuantiteRajout").getText());
//	        			for(JTextField tf: entreesAjoutOrdi.values()){
//	        				tf.setText(null);
//	        			}
//	        		}
	        		else{
	        			if(ItemSelect == COMMANDER)
	        				if(!NullEntrees(entreesCommande))
	        					entrepot.Commander(entreesCommande.get("Code").getText(),
	        									Integer.parseInt( entreesCommande.get("Quantite").getText() ),
	        									entreesCommande.get("Nom").getText(),
	        									entreesCommande.get("Adresse").getText());
	        			for(JTextField tf: entreesAjoutOrdi.values()){
	        				tf.setText(null);
	        			}
	        		}
	        }
		}
	}
	

}
