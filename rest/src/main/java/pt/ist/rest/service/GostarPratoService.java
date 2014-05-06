<<<<<<< HEAD
package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.PratoSimpleDto;

import pt.ist.rest.service.dto.ClienteDto;

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

		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getUser());
		final Prato prato = rest.procuraPratoEmRestaurante(restauranteDto.getNome(),pratoDto.getAtributo());	
		cliente.addGosto(prato);
			
	}

}

		


	
	





||||||| merged common ancestors
package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.PratoSimpleDto;

import pt.ist.rest.service.dto.ClienteDto;

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

		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getUser());
		final Prato prato = rest.procuraPratoEmRestaurante(restauranteDto.getNome(),pratoDto.getNome());	
		cliente.addGosto(prato);
			
	}

}

		


	
	





=======
package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.PratoSimpleDto;

import pt.ist.rest.service.dto.ClienteDto;

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

		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getUser());
		final Prato prato = rest.procuraPratoEmRestaurante(restauranteDto.getNome(),pratoDto.getNome());	
		cliente.addGosto(prato);
			
	}

}

		


	
	





>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
