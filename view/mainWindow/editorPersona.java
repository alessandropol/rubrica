package view.mainWindow;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class editorPersona extends JFrame {
	private JLabel nomeL = new JLabel("Nome");
	private JLabel cognomeL = new JLabel("Cognome");
	private JLabel indirizzoL = new JLabel("Indirizzo");
	private JLabel telefonoL = new JLabel("Telefono");
	private JLabel etaL = new JLabel("Età");	 
	private JTextField nomeT = new JTextField(20);
	private JTextField cognomeT = new JTextField(20);
	private JTextField indirizzoT = new JTextField(30);
	private JTextField telefonoT = new JTextField(10);
	private JTextField etaT = new JTextField(2);
	private JButton BSave = new JButton("Salva");
	private JButton BCancel = new JButton("Annulla");
	private JToolBar tbar= new JToolBar();
	private JPanel pan=new JPanel(); 
 	private int IDcontactModify=-1;
	 
	 public editorPersona() {
		super("Contatto");
		
		Container cont = new Container();
		cont.setLayout(new BorderLayout());
			
		pan.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_END;
		pan.add(this.nomeL, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.nomeT, gbc);

			
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.cognomeL, gbc);
			
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.cognomeT, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 5);
		pan.add(this.indirizzoL, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.indirizzoT, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 5);
		pan.add(this.telefonoL, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.telefonoT, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5, 0, 0, 5);
		pan.add(this.etaL, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		pan.add(this.etaT, gbc);
			
		setSize(500,300);
				
		tbar.setRollover(true);

		tbar.add(BSave);
		tbar.add(BCancel);
		
		cont.add(tbar,BorderLayout.NORTH);
		cont.add(pan,BorderLayout.CENTER);
		this.add(cont);
		
		this.setLocationRelativeTo(null);
	 }
	 
	 //conessione VIEW-CONTROLLER
	 public void addListener(ActionListener actionL) {
		 BSave.addActionListener(actionL);
		 BCancel.addActionListener(actionL);
	 }
	 
	 public String[] getField() {
		 String[] s=new String[5];
		 s[0]= nomeT.getText();
		 s[1]=cognomeT.getText();
		 s[2]=indirizzoT.getText();
		 s[3]=telefonoT.getText();
		 s[4]=etaT.getText();
		 return s;
	}
	
	public void cleanField() {
		nomeT.setText("");
		cognomeT.setText("");
		indirizzoT.setText("");
		telefonoT.setText("");
		etaT.setText("");
	}
	
	public void setField(String[] datip) {
		 nomeT.setText(datip[0]);
		 cognomeT.setText(datip[1]);
		 indirizzoT.setText(datip[2]);
		 telefonoT.setText(datip[3]);
		 etaT.setText(datip[4]);
	}
	
	public void setFieldEditable(boolean b) {
		 nomeT.setEditable(b);
		 cognomeT.setEditable(b);
		 indirizzoT.setEditable(b);
		 telefonoT.setEditable(b);
		 etaT.setEditable(b);
	}
	
	public void EnableSaveButton(boolean value){
		BSave.setEnabled(value);
	}
	
	public void setIDcontactModify(int ID){
		IDcontactModify=ID;
	}
	
	public int getIDcontactModify(){
		return IDcontactModify;
	}
	
 	 
}
