package view.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginWindow extends JFrame {
	 private JLabel userL = new JLabel("User");
	 private JLabel passwordL = new JLabel("Password");
	 private JLabel errorL = new JLabel("Utente o Password non corretti");
	 private JTextField userT = new JTextField(20);
	 private JTextField passwordT = new JTextField(20);
	 private JButton loginB=new JButton("Login");
	 private JPanel pan=new JPanel(); 

	 
	 public loginWindow() {
		super("Benvenuto in Rubrica");
		
		Container cont = new Container();
		cont.setLayout(new BorderLayout());
					
		pan.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_END;
		pan.add(this.userL, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.userT, gbc);

			
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.passwordL, gbc);
			
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.passwordT, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_END;
		pan.add(this.loginB, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_END;
		errorL.setForeground(Color.red);
		errorL.setBackground(Color.black);
		errorL.setFont(new Font("Serif", Font.PLAIN, 14));
		errorL.setVisible(false);
		pan.add(this.errorL, gbc);
		
		setSize(1000,600);
		    
		cont.add(pan,BorderLayout.CENTER);
		this.add(cont);
		this.setLocationRelativeTo(null);

	 }
	 
	 public String getUsername() {
		 return userT.getText();
	 }
	 
	 public String getPassword() {
		 return passwordT.getText();
	 }
	 
	 public void setVisibleError(boolean b){
		 errorL.setVisible(b);
	 }
	 
	 public void addLoginButtonListener(ActionListener lsnloginB){
		 loginB.addActionListener(lsnloginB);
	 }
}
