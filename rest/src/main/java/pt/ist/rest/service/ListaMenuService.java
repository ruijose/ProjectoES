package pt.ist.rest.service;
import pt.ist.rest.exception.*;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.PratoDto;

import java.util.List;
import java.util.ArrayList;


public class ListaMenuService extends RestService {

	
	private String nomeR;
	
	public ListaMenuService(String nomeRestaurante) {
		   this.nomeR = nomeRestaurante;
		
	}
	
	private RestauranteDto result;
	
	public final void dispatch() throws DishNotFoundException{
		Rest rest = FenixFramework.getRoot();
		
		List<PratoDto> pratoDtoList = new ArrayList<PratoDto>();
		
		Restaurante restaurante = rest.procuraRestaurantePorNome(nomeR);
		
		if (restaurante.getPratoCount() == 0)
			throw new DishNotFoundException(restaurante.getNome());
		
		for (Prato p: restaurante.getPratoSet()) {
			 PratoDto view = new PratoDto(p.getNome(),p.getCalorias(),p.getPreco(),p.calculaClassificacao());
			 pratoDtoList.add(view);
		}
	    this.result = new RestauranteDto(restaurante.getNome(),restaurante.getMorada(),restaurante.calculaClassificacao(), pratoDtoList);
	}
	
	public RestauranteDto getResult(){
		return this.result;
	}
}