package model;

public class persona extends contatto {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String telefono;
	private int eta;
	
	public persona(String _nome, String _cognome, String _ind, String _tel, int _eta) {
		super();		
		nome=_nome;
		cognome=_cognome;
		indirizzo=_ind;
		telefono=_tel;
		eta=_eta;
	}

	public persona(persona tp) {
		super(tp);
		nome=tp.getNome();
		cognome=tp.getCognome();
		indirizzo=tp.getIndirizzo();
		telefono=tp.getTelefono();
		eta=tp.getEta();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String _cognome) {
		this.cognome = _cognome;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String _indirizzo) {
		this.indirizzo = _indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String _telefono) {
		this.telefono = _telefono;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int _eta) {
		this.eta = _eta;
	}
	
	
	
	

}
