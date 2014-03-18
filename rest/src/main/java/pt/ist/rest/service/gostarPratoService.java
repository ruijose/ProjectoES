package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.PratoDto;
<<<<<<< HEAD
import pt.ist.rest.service.dto.ClienteDto;

=======
import java.util.List;
import java.util.ArrayList;
>>>>>>> 9dad73d86a8ff46ed0f3ab0ae17ed545f72d6dfe


public class gostarPratoService extends RestService {


<<<<<<< HEAD
	private RestauranteDto restauranteDto;
	private PratoDto pratoDto;
	private ClienteDto clienteDto;
=======
	private RestauranteDto restaurante;
	private PratoDto prato;
	private CLienteDto cliente;
>>>>>>> 9dad73d86a8ff46ed0f3ab0ae17ed545f72d6dfe


	public gostarPratoService(RestauranteDto nomeRestaurante, PratoDto nomePrato, ClienteDto nomeCliente) {

<<<<<<< HEAD
		   this.restauranteDto = nomeRestaurante;
		   this.pratoDto = nomePrato;
		   this.clienteDto = nomeCliente;
=======
		   this.restaurante = nomeRestaurante;
		   this.prato = nomePrato;
		   this.cliente = nomeCliente;
>>>>>>> 9dad73d86a8ff46ed0f3ab0ae17ed545f72d6dfe
		
	}

	public final void dispatch(){

		Rest rest = FenixFramework.getRoot();
			
<<<<<<< HEAD
		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getNome());
		final Restaurante restaurante = rest.procuraRestaurantePorNome(restauranteDto.getNome());
		final Prato prato = rest.procuraPratoEmRestaurante(restaurante.getNome(),pratoDto.getNomeP());

		cliente.addGosto(prato);

			
	}

}

=======
		final Cliente cliente = rest.procuraClientePorNome(cliente.getNome());
		final Restaurante restaurante = rest.procuraRestaurantePorNome(restaurante.getNome());
		final Prato prato = rest.procuraPratoEmRestaurante(restaurante.getNome(),prato.getNomeP());

		this.cliente.addGosto(prato);

			
		}

	}

}
>>>>>>> 9dad73d86a8ff46ed0f3ab0ae17ed545f72d6dfe
