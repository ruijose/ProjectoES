package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.domain.Rest;
import pt.ist.rest.domain.Prato;
import pt.ist.rest.domain.Restaurante;
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
		List<PratoDeRestauranteDto> pratoRestaurante = new ArrayList<PratoDeRestauranteDto>();

		for(Restaurante r: rest.getRestauranteSet()){
			final Prato prato = rest.procuraPratoEmRestaurante(r.getNome(), dto.getNome());
	 		 if(prato!=null){
	 			 PratoDeRestauranteDto pratoRest = new PratoDeRestauranteDto(prato.toString(),r.getNome());
	 			 pratoRestaurante.add(pratoRest);
	 		 }
	 	}

		result= new PratosDto(pratoRestaurante); 
	}

	public final PratosDto getResult(){
		return result;
	}
}