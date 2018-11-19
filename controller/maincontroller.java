package controller;

import view.login.loginWindow;
import view.mainWindow.mainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import model.*;

//CONTROLLER
public class maincontroller {
	private loginWindow loginW;
	private mainWindow mainW;
	private user user;
	private database DB;
	
	public maincontroller(loginWindow _loginW, database _DB){
		loginW=_loginW;
		DB=_DB;

		loginW.addLoginButtonListener(new LoginButtonListener());
		loginW.setVisible(true);
	}
	//connessione VIEW-CONTROLLER
	public void addMainListener() {
		mainW.addMainWindowListener(new mainWindowListener());
		mainW.addEditFrameListener(new editPersonaListener());
		mainW.addModifyViewListener(new modifyViewPersonaListener());
	}
	
	//Listener Login
	class LoginButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userName=loginW.getUsername();
			String password=loginW.getPassword();
			try {
				if(isUser(userName,password)) {//controllo credenziali
					loadUtente(userName, password);
					utente UT=(utente)user;
					mainW=new mainWindow(userName, UT.getNome(),UT.getCognome());
					addMainListener();
					mainW.updateContactTable(contactForTable());
					loginW.setVisible(false);
					mainW.setVisible(true);					
				}
				else {
					loginW.setVisibleError(true);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	//Listener MainWindow
	class mainWindowListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton bt=(JButton)e.getSource();
			
			//apertura frame inserimento contatto
			if(bt.getText().equals("Nuovo"))
				mainW.setVisibleEditFrame(true);
			
			//apertura frame eliminazione contatto
			if(bt.getText().equals("Elimina")) {
				if(mainW.isrowtbleselected())
					mainW.showMessageDialog("Selezionare una riga");
				else {
					try {
						eliminaContatto(mainW.getDataSelTable());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			//apertura frame modifica contatto
			if(bt.getText().equals("Modifica")) {
				if(mainW.isrowtbleselected())
					mainW.showMessageDialog("Selezionare una riga");
				else {
					String[] rowS=mainW.getDataSelTable();
					utente UT=(utente)user;
					int ID=UT.getIdContatto(rowS);
					persona p=UT.getPersona(ID);
					String[] datiP=new String[5];
					datiP[0]=p.getNome();
					datiP[1]=p.getCognome();
					datiP[2]=p.getIndirizzo();
					datiP[3]=p.getTelefono();
					datiP[4]=Integer.toString(p.getEta());				
					mainW.setFieldMVPersona(datiP);
					mainW.setMVPersonaID(ID);
					mainW.setMVPButtonsave(true);
					mainW.setVisibleMVPersona(true);
					mainW.setFieldEditableMVPersona(true);
				}
			}
			//apertura frame viasualizza contatto
			if(bt.getText().equals("Visualizza")) {
				if(mainW.isrowtbleselected())
					mainW.showMessageDialog("Selezionare una riga");
				else {
					String[] rowS=mainW.getDataSelTable();
					utente UT=(utente)user;
					int ID=UT.getIdContatto(rowS);
					persona p=UT.getPersona(ID);
					String[] datiP=new String[5];
					datiP[0]=p.getNome();
					datiP[1]=p.getCognome();
					datiP[2]=p.getIndirizzo();
					datiP[3]=p.getTelefono();
					datiP[4]=Integer.toString(p.getEta());				
					mainW.setFieldMVPersona(datiP);
					mainW.setFieldEditableMVPersona(false);
					mainW.setMVPButtonsave(false);
					mainW.setVisibleMVPersona(true);
				}
			}
		}
	}
	
	//Listener Inserimento contatto
	class editPersonaListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton bt=(JButton)e.getSource();
			//Creazione ed inserimento nuovo contatto
			if(bt.getText().equals("Salva")){
				String[] datip=mainW.getFieldEditPersona();
				if(checkDatiPersona(datip)){//Controllo dati
					mainW.showMessageDialog("Contato non inserito");
					mainW.cleanFieldEditPersona();
				}
				else {
					try {
						insertContatto(datip);//se corretto viene inserito in model
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					updateMainWTable();//aggioranemnto vista
					mainW.cleanFieldEditPersona();
					mainW.setVisibleEditFrame(false);
				}
			}
			else if(bt.getText().equals("Annulla")){
				mainW.cleanFieldEditPersona();
				mainW.setVisibleEditFrame(false);
			}
		}
	}

	//Listener Modifica condatto
	class modifyViewPersonaListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton bt=(JButton)e.getSource();
			if(bt.getText().equals("Salva")){
				String[] datip=mainW.getFieldMVPersona();
				if(checkDatiPersona(datip)){//controllo dati
					mainW.showMessageDialog("Contato non modificato");
					mainW.cleanFieldEditPersona();
				}
				else {
					try {
						utente UT=(utente)user;
						persona p=UT.getPersona(mainW.getMVPersonaID());
						String[] perdel=new String [3];
						perdel[0]=p.getNome();
						perdel[1]=p.getCognome();
						perdel[2]=p.getTelefono();
						eliminaContatto(perdel);
						insertContatto(datip);
						mainW.setVisibleMVPersona(false);
						updateMainWTable();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			else if(bt.getText().equals("Annulla")){
				mainW.cleanFieldMVPersona();
				mainW.setVisibleMVPersona(false);
			}
		}
	}

	//controllo nel DB se esiste l'utente
	public boolean isUser(String _userName, String _pss) throws IOException{		
		ArrayList<String> array=(ArrayList<String>) DB.readDB("users");
		for (String row : array) {
			int index=row.indexOf(";");
			if(_userName.equals(row.substring(0, index)) && _pss.equals(row.substring(index+1, row.length())) ) 
				return true;
		}
		return false;
	}
	
	//carico informazioni utente e settaggio VIEW
	public void loadUtente(String _username, String _password) throws IOException{
		fileDB DBF=(fileDB)DB;
		DBF.setFileUtente(_username);
		ArrayList<String> array=(ArrayList<String>) DBF.readDB("utente");
		utente UT=new utente(_username,_password); 
		for (String row : array) {
			if(!(row.substring(0,1).equals("#"))) {
				String[] sw=row.split(";");
				UT.addContatto(sw[0], sw[1], sw[2], sw[3],Integer.parseInt(sw[4]));			
			}
			if(row.substring(0, 2).equals("#1"))
				{
				UT.setNome(row.substring(2, row.length()));
				}
			if(row.substring(0, 2).equals("#2")) {
				UT.setCognome(row.substring(2, row.length()));
			}
		}
		user=UT;
	}
	
	//codifica dati utente per inserimento nella VIEW
	public String[][] contactForTable(){
		utente UT=(utente)user;
		ArrayList<contatto> array=UT.getContatti();
		String[][] sft=new String[array.size()][3];
		
		for(int i=0;i<array.size();i++) {
				persona p=(persona)array.get(i);
				sft[i][0]=p.getNome();
				sft[i][1]=p.getCognome();
				sft[i][2]=p.getTelefono();
		}
		return sft;
	}
	
	//aggiornamento tabella VIEW
	public void updateMainWTable() {
		mainW.ClearContactTable();
		mainW.updateContactTable(this.contactForTable());
	}
	
	//Inserimento nuovo contatto in MODEl e DB
	public void insertContatto(String[] element) throws IOException
	{
		utente UT=(utente)user;
		UT.addContatto(element[0], element[1], element[2], element[3], Integer.parseInt(element[4]));
		writeDB(element[0]+";"+element[1]+";"+element[2]+";"+element[3]+";"+element[4]);
	}
	
	//Eliminzaione contatto in MODEL e DB
	public void eliminaContatto(String[] element) throws IOException {
		utente UT=(utente)user;
		int ID=UT.getIdContatto(element);
		persona p=UT.getPersona(ID);
		DB.deleteDB(p.getNome()+";"+p.getCognome()+";"+p.getIndirizzo()+";"+p.getTelefono()+";"+p.getEta());
		UT.remContatto(ID);	
		updateMainWTable();
	}
	
	//Scrittura nel DB
	public void writeDB(String element) throws IOException {
		fileDB FDB=(fileDB) DB;
		FDB.insertDB(element);
	}
	
	//Controllo dati
	public boolean checkDatiPersona(String[] datip){
		boolean error=false;
		if(datip[0].isEmpty()){
			mainW.showMessageDialog("Errore: inserire Nome");
			error=true;
		}
		if(datip[1].isEmpty()){
			mainW.showMessageDialog("Errore: inserire Cognome");
			error=true;
		}
		if(datip[2].isEmpty()){
			mainW.showMessageDialog("Errore: inserire Indirizzo");
			error=true;
		}
		if(datip[3].isEmpty()){
			mainW.showMessageDialog("Errore: inserire Telefono");
			error=true;
		}
		if(datip[4].isEmpty()){
			mainW.showMessageDialog("Errore: inserire Età");
			error=true;
		}
		return error;
	}
	
	
	

}
