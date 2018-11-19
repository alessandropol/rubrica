package model;

import java.io.IOException;
import java.util.ArrayList;

public class fileDB implements database {
	
	fileTXT fileUsers;
	fileTXT fileUtente;
	
	public fileDB(String _usersFile) throws IOException{
		fileUsers=new fileTXT(_usersFile);
	}
	
	public fileDB(String _usersFile, String _utenteFile) throws IOException{
		fileUsers=new fileTXT(_usersFile);
		fileUtente=new fileTXT(_utenteFile);
	}
	

	public void insertDB(String _element) throws IOException{
		fileUtente.write(_element);
	}

	
	public void deleteDB(String _element) throws IOException {
		fileUtente.delete(_element);

	}

	public ArrayList<String> readDB(String _element) throws IOException {
		ArrayList<String> array;
		if(_element.equals("users")) {
			array=fileUsers.load();
		}
		else if(_element.equals("utente"))
			array=fileUtente.load();
		else
			array=new ArrayList<String>();
		return array;
	}
	
	public void setFileUtente(String fileU){
		fileUtente=new fileTXT(fileU);
	}

}
