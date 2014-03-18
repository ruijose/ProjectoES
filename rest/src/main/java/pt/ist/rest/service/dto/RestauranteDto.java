package pt.ist.rest.service.dto;

import java.util.List;


public class RestauranteDto extends RestauranteSimpleDto {
	
	private List<PratoDto> pratoDtoList;
	
	public RestauranteDto(String nameR,String morada,int classificacao,List<PratoDto> dtoList){
		super(nameR,morada,classificacao);
		pratoDtoList = dtoList;
		
	}
	
	public List<PratoDto> getPratos(){
		return this.pratoDtoList;
	}

}
