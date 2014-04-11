package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.domain.Rest;
import pt.ist.rest.domain.Prato;
import pt.ist.rest.service.dto.PratoDeRestauranteDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratosDto;


public class ProcuraPratoService extends RestService {
	private PratoDto dto;
	private PratosDto result;

	public ProcuraPratoService(PratoDto dto){
		this.dto=dto;
	}

	public final void dispatch(){
		Rest rest = FenixFramework.getRoot();
		final List<PratoDeRestauranteDto> pratosDto = new ArrayList<PratoDeRestauranteDto>();
		final List<Prato> pratosRestaurante = rest.procuraPratoSubstring(dto.getNome());
	
		for (Prato p: pratosRestaurante){
			pratosDto.add(new PratoDeRestauranteDto(p.toString(),p.getRestaurante().getNome()));
		}

		result= new PratosDto(pratosDto); 
	}

	public final PratosDto getResult(){
		return result;
	}
}