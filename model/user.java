package model;

public abstract class user {
	private String username;
	private String password;
	
	public user(String usr, String pss) {
		username=usr;
		password=pss;
	}
	
	public void setUsername(String _usr) {
		username=_usr;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String _pss) {
		password=_pss;
	}
	
	public String getPassword(String pss){
		return password;
	}

}
