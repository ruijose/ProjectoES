<<<<<<< HEAD
package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.DishesNotFoundException;
import pt.ist.rest.service.dto.*;

public class ProcuraPratoPorTipoService extends RestService{
	
	final private PratoTipoDto pratoDto;
	private PratosDto result;


	public ProcuraPratoPorTipoService(PratoTipoDto pratoTipoDto) {
		   this.pratoDto = pratoTipoDto;
	}

	public final void dispatch() throws DishesNotFoundException{
		
		Rest rest = FenixFramework.getRoot();
		List<PratoDeRestauranteDto> pratosDto = new ArrayList<PratoDeRestauranteDto>();
		List<Prato> pratosRestaurante = rest.procuraPratos(pratoDto.getAtributo());
		
		for (Prato p: pratosRestaurante){
		//	pratosDto.add(new PratoDeRestauranteDto(p.toString(),p.getRestaurante().getNome()));
		}
		result = new PratosDto(pratosDto);	
	}

	public final PratosDto getResult(){
		return result;
	}

}

||||||| merged common ancestors
package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.DishesNotFoundException;
import pt.ist.rest.service.dto.*;

public class ProcuraPratoPorTipoService extends RestService{
	
	final private PratoTipoDto pratoDto;
	private PratosDto result;


	public ProcuraPratoPorTipoService(PratoTipoDto pratoTipoDto) {
		   this.pratoDto = pratoTipoDto;
	}

	public final void dispatch() throws DishesNotFoundException{
		Rest rest = FenixFramework.getRoot();
		List<PratoDeRestauranteDto> pratosDto = new ArrayList<PratoDeRestauranteDto>();
		
		List<Prato> pratosRestaurante = rest.procuraPratosTipo(pratoDto.getNome());
		for (Prato p: pratosRestaurante){
			pratosDto.add(new PratoDeRestauranteDto(p.toString(),p.getRestaurante().getNome()));
		}
		result = new PratosDto(pratosDto);	
	}

	public final PratosDto getResult(){
		return result;
	}

}

=======
package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.DishesNotFoundException;
import pt.ist.rest.service.dto.*;

public class ProcuraPratoPorTipoService extends RestService{
	
	final private PratoTipoDto pratoDto;
	private PratosDto result;


	public ProcuraPratoPorTipoService(PratoTipoDto pratoTipoDto) {
		   this.pratoDto = pratoTipoDto;
	}

	public final void dispatch() throws DishesNotFoundException{
		Rest rest = FenixFramework.getRoot();
		List<PratoDeRestauranteDto> pratosDto = new ArrayList<PratoDeRestauranteDto>();
		
		List<Prato> pratosRestaurante = rest.procuraPratosTipo(pratoDto.getNome());
		for (Prato p: pratosRestaurante){
			pratosDto.add(new PratoDeRestauranteDto(p.toString(),p.getRestaurante().getNome()));
		}
		result = new PratosDto(pratosDto);	
	}

	public final PratosDto getResult(){
		return result;
	}

}

>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
