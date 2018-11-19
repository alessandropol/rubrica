package model;

public abstract class contatto implements Cloneable  {
	private static int numeroSeq=0;
	private final int IDContatto;
	
	public contatto(){
		IDContatto= numeroSeq;
		numeroSeq++;
	}
	
	public contatto(contatto c)
	{
		IDContatto=c.getIDContatto();
	}
	
	public int getIDContatto() {
		return IDContatto;
	}
}
