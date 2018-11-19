package model;

import java.util.AbstractCollection;

public interface listaContatti {
	
	public void addContatto(contatto _cnt);
	public void remContatto(int ID);
	public contatto getContatto(int ID);
	public AbstractCollection<contatto> getContatti(); 
}
