package model;
import java.util.ArrayList; 

public class rubrica implements listaContatti {
	
	private ArrayList<contatto> contenitore;
	
	public rubrica() {
		contenitore= new ArrayList<contatto>();
	}
	
	public rubrica(ArrayList<contatto> _array) {
		contenitore= _array;
	}
	
	public void addContatto(contatto _cnt){
		contenitore.add(_cnt);
	}
	
	public void remContatto(int ID) {
		int index=-1;
		for(int i=0;i<contenitore.size();i++) {
			if(contenitore.get(i).getIDContatto()==ID)
				index=i;
		}
		contenitore.remove(index);
	}
	
	public void addPersona(String _nome, String _cognome,String _ind, String _tel, int _eta) {
		persona per=new persona(_nome, _cognome, _ind, _tel,_eta);
		this.addContatto(per);
	}
	
	public void modPersona(int ID, String _nome, String _cognome,String _ind, String _tel, int _eta) {
		this.remContatto(ID);
		this.addPersona(_nome, _cognome, _ind, _tel, _eta);
	}
	
	public int getNumeroContatti() {
		return contenitore.size();
	}
	
	public ArrayList<contatto> getContatti(){
		ArrayList<contatto> clone = new ArrayList<contatto>(contenitore.size());
	    for (contatto item : contenitore) {
	    	persona per=(persona)item;   	
	    	clone.add(new persona(per));
	    }
	    return clone;
	}
	
	public int getIDContatto(String[] cnt) {
	    for (contatto item : contenitore) {
	    	persona per=(persona)item;
	    	if(   per.getNome().equals(cnt[0]) && per.getCognome().equals(cnt[1]) && per.getTelefono().equals(cnt[2])  )
	    		return per.getIDContatto();
	    }
	    return -1;
	}
	
	public contatto getContatto(int ID){
	    for (contatto item : contenitore) {
	    	if(item.getIDContatto()==ID)
	    		return new persona((persona) item);
	    }
	    return null;
	}
}
