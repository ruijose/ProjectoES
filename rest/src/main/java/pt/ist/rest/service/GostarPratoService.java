package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.PratoSimpleDto;

import pt.ist.rest.service.dto.ClienteDto;

import java.util.List;
import java.util.ArrayList;



public class GostarPratoService extends RestService {

	final private RestauranteSimpleDto restauranteDto;
	final private PratoSimpleDto pratoDto;
	final private ClienteDto clienteDto;



	public GostarPratoService(RestauranteSimpleDto restaurante, PratoSimpleDto prato, ClienteDto cliente) {


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

		


	
	





