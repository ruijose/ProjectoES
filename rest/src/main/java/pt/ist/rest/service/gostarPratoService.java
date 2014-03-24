package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.ClienteDto;

import java.util.List;
import java.util.ArrayList;


public class gostarPratoService extends RestService {


	private RestauranteDto restauranteDto;
	private PratoDto pratoDto;
	private ClienteDto clienteDto;
	private RestauranteDto restaurante;
	private PratoDto prato;
	private CLienteDto cliente;


	public gostarPratoService(RestauranteDto nomeRestaurante, PratoDto nomePrato, ClienteDto nomeCliente) {

		   this.restauranteDto = nomeRestaurante;
		   this.pratoDto = nomePrato;
		   this.clienteDto = nomeCliente;
		   this.restaurante = nomeRestaurante;
		   this.prato = nomePrato;
		   this.cliente = nomeCliente;
		
	}

	public final void dispatch(){

		Rest rest = FenixFramework.getRoot();
			
		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getNome());
		final Restaurante restaurante = rest.procuraRestaurantePorNome(restauranteDto.getNome());
		final Prato prato = rest.procuraPratoEmRestaurante(restaurante.getNome(),pratoDto.getNomeP());

		cliente.addGosto(prato);

			
	}

}

		final Cliente cliente = rest.procuraClientePorNome(cliente.getNome());
		final Restaurante restaurante = rest.procuraRestaurantePorNome(restaurante.getNome());
		final Prato prato = rest.procuraPratoEmRestaurante(restaurante.getNome(),prato.getNomeP());

		this.cliente.addGosto(prato);

			
		}

	}

}
