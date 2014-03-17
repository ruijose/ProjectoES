package pt.ist.rest.service.dto;

public class UtilizadorDto{

	private final String pass;
	private final String user;

	public UtilizadorDto(String user, String pass) {
		this.pass = pass;
		this.user = user;
		
	}

	public final String getPass() {
		return pass;
	}

	public final String getUser() {
		return user;
	}
	
	
}
	
	
	
	