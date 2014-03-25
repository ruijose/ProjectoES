package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.ClienteDto;

public class ActualizaSaldoService extends RestService{

	final private ClienteDto clienteDto;
	final private int valor;


	public ActualizaSaldoService(ClienteDto clienteDto, int valor) {

		   this.clienteDto = clienteDto;
		   this.valor = valor;

	}

	public final void dispatch(){
		final Rest rest = FenixFramework.getRoot();
		final Cliente cliente = rest.procuraClientePorNome(this.clienteDto.getNome());

		cliente.addSaldo(this.valor);	
	}

}

		

