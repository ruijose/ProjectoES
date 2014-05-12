package pt.ist.rest.service.dto;

public class PratoSimpleDto implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private String atributo;
    private String[] opcoes;
	
	public PratoSimpleDto() {}
	
	public PratoSimpleDto(String atributo) {
		this.atributo = atributo;
	}
	
	
	public String getAtributo() {
		return atributo;
	}
	
	
	

}
