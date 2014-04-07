package pt.ist.rest.service.dto;

public class PratoTipoDto extends PratoSimpleDto {

	private final String tipoPrato;
	
	public PratoTipoDto(String nome,String tipo){
		super(nome);
		this.tipoPrato = tipo;
	}
	
	public String getTipoPrato(){
		return tipoPrato;
	}
	
}
