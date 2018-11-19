package model;

import java.util.ArrayList;

public class utente extends user {
	private String nome;
	private String cognome;
	private listaContatti rubrica;

	
	public utente(String _usr, String _pss) {
		super(_usr,_pss);
		rubrica= new rubrica();
	}
	
	public utente(String _nome, String _cognome, String _pss, String _usr,ArrayList<contatto> _array) {
		super(_usr,_pss);
		nome=_nome;
		cognome=_cognome;
		rubrica= new rubrica(_array);
	}
	
	public void setNome(String _nome) {
		nome=_nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String _cognome){
		cognome=_cognome;		
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void addContatto(String _nome, String _cognome,String _ind, String _tel, int _eta){
		rubrica rub=(rubrica)rubrica;
		rub.addPersona(_nome, _cognome, _ind, _tel, _eta);
	}
	
	public void remContatto(int ID) {
		rubrica.remContatto(ID);
	}
	
	public void modContatto(int ID, String _nome, String _cognome,String _ind, String _tel, int _eta){
		rubrica rub=(rubrica)rubrica;
		rub.modPersona(ID, _nome, _cognome, _ind, _tel, _eta);
	}
	
	public ArrayList<contatto> getContatti(){
		return (ArrayList<contatto>)rubrica.getContatti();
	}
	
	public int getIdContatto(String[] cnt) {
		rubrica rub=(rubrica)rubrica;
		return rub.getIDContatto(cnt);
	}
	
	public contatto getContatto(int ID) {
		return rubrica.getContatto(ID);
	}
	
	public persona getPersona(int ID) {
		return (persona)getContatto(ID);
	}
	
	public int getsizeContatti() {
		rubrica rub=(rubrica)rubrica;
		return rub.getNumeroContatti();
	}

	
}
