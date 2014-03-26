package pt.ist.rest.service.dto;

import java.util.List;

public class PratosDto {
	private List<PratoDeRestauranteDto> pratoRestaurante;

	public PratosDto(List<PratoDeRestauranteDto> dto){
		this.pratoRestaurante = dto;
	}

	public List<PratoDeRestauranteDto> getPratoRestaurante() {
		return pratoRestaurante;
	}

}
