package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.PratoDto;

import pt.ist.rest.service.dto.ClienteDto;

import java.util.List;
import java.util.ArrayList;



public class RegistaPagamentoTabuleiroComprasService extends RestService {

	final private ClienteDto clienteDto;



	public RegistaPagamentoTabuleiroComprasService(ClienteDto cliente) {


		   this.clienteDto = cliente;

	}

	public final void dispatch(){

		Rest rest = FenixFramework.getRoot();

		final Cliente cliente = rest.procuraClientePorNome(this.clienteDto.getNome());
		
		
		cliente.confirmaCompra();
			
	}

}

		


	
	





