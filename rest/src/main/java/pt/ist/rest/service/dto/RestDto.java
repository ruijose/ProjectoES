package pt.ist.rest.service.dto;


import java.util.List;

public class RestDto {

	private List<RestauranteSimpleDto> restauranteSimple; 

	public RestDto(List<RestauranteSimpleDto> dto){
		this.restauranteSimple = dto;
	}

	public List<RestauranteSimpleDto> getRestaurantes(){
		return this.restauranteSimple;
	}

}
