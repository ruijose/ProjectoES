package pt.ist.rest.service.dto;


import java.util.List;

public class RestDto {

	private List<RestauranteSimpleDto> restauranteSimple;
	private List<PratoDeRestauranteDto> pratoRestaurante;

	public RestDto(List<RestauranteSimpleDto> dto){
		this.restauranteSimple = dto;
	}

	public RestDto(List<PratoDeRestauranteDto> dto){
		this.pratoRestaurante=dto;
	}
	
	public List<RestauranteSimpleDto> getRestaurantes(){
		return this.restauranteSimple;
	}

}
