package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.domain.Rest;
import pt.ist.rest.domain.Prato;
import pt.ist.rest.exception.DishesNotFoundException;
import pt.ist.rest.service.dto.PratoDeRestauranteDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.PratosDto;


public class ProcuraPratoService extends RestService {
	private PratoSimpleDto dto;
	private PratosDto result;

	public ProcuraPratoService(PratoSimpleDto dto){
		this.dto=dto;
	}

	public final void dispatch()throws DishesNotFoundException{
	
		Rest rest = FenixFramework.getRoot();
		final List<PratoDeRestauranteDto> pratosDto = new ArrayList<PratoDeRestauranteDto>();
		
		final List<Prato> pratosRestaurante = rest.procuraPratos(dto.getAtribu  to());
	
		if(pratosRestaurante == null){
			throw new DishesNotFoundException();
		}
		
		for (Prato p: pratosRestaurante){
			pratosDto.add(new PratoDeRestauranteDto(p.getNome(),p.getCalorias(),p.getPreco(),p.calculaClassificacao(),p.getRestaurante().getNome()));
		}

		result= new PratosDto(pratosDto); 
	}

	public final PratosDto getResult(){
		return result;
	}
}