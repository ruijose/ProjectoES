package pt.ist.rest.service.dto;

import java.util.List;


public class RestauranteDto extends RestauranteSimpleDto {
	private static final long serialVersionUID = 1L;
	private List<PratoDeRestauranteDto> pratoDtoList;
	
	public RestauranteDto() {}
	public RestauranteDto(String nameR,String morada,int classificacao,List<PratoDeRestauranteDto> dtoList){
		super(nameR,morada,classificacao);
		pratoDtoList = dtoList;
		
	}
	
	public List<PratoDeRestauranteDto> getPratos(){
		return this.pratoDtoList;
	}

}
