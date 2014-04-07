package pt.ist.rest.service.dto;

public class PratoSimpleDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomeP;

	public PratoSimpleDto(){
		
	}
	public PratoSimpleDto(String nomeP) {
		this.nomeP = nomeP;
	}

	public String getNome() {
		return nomeP;
	}
	
	
	

}
