package view.mainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class jpanel_west_infoUtente extends JPanel {
	 private JLabel labelUsername = new JLabel();
	 private JLabel labelNomeUtente = new JLabel();
	 private JLabel labelCognomeUtente = new JLabel();
	 
	
	 public jpanel_west_infoUtente(String _nomeU, String _nome, String _cognome) {
		 super(new GridLayout(14,0,0,2)); 
		 
		 labelUsername.setText("Username: " + _nomeU);
		 if(_nome==null || _cognome==null) {
			 labelNomeUtente.setVisible(false);
			 labelCognomeUtente.setVisible(false);
		 }
		 else {
			 labelNomeUtente.setText("Nome: " + _nome);
			 labelCognomeUtente.setText("Cognome: " + _cognome);
		 }
		 
		 
		 this.add(labelUsername);
		 this.add(labelNomeUtente);
		 this.add(labelCognomeUtente);
		 this.setPreferredSize(new Dimension(400, 600));    
		 this.setBorder(BorderFactory.createCompoundBorder(
			        BorderFactory.createLineBorder(Color.black, 2), 
			        BorderFactory.createEmptyBorder(10, 10, 0, 0)));
	 }
}
