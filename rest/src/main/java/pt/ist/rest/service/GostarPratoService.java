package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.PratoDto;

import pt.ist.rest.service.dto.ClienteDto;

import java.util.List;
import java.util.ArrayList;



public class GostarPratoService extends RestService {

	final private RestauranteDto restauranteDto;
	final private PratoDto pratoDto;
	final private ClienteDto clienteDto;



	public GostarPratoService(RestauranteDto restaurante, PratoDto prato, ClienteDto cliente) {


		   this.restauranteDto = restaurante;
		   this.pratoDto = prato;
		   this.clienteDto = cliente;

	}

	public final void dispatch(){

		Rest rest = FenixFramework.getRoot();

		final Cliente cliente = rest.procuraClientePorNome(this.clienteDto.getNome());
		final Restaurante restaurante = rest.procuraRestaurantePorNome(this.restauranteDto.getNome());
		final Prato prato = rest.procuraPratoEmRestaurante(this.restauranteDto.getNome(),this.pratoDto.getNome());
			
		cliente.addGosto(prato);
			
	}

}

		


	
	





