package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Cliente;
import pt.ist.rest.domain.Rest;
import pt.ist.rest.exception.RestException;
import pt.ist.rest.service.dto.ClienteDto;

public class EsvaziarTabuleiroComprasService extends RestService {
	
	private ClienteDto clienteDto;
	
	public EsvaziarTabuleiroComprasService(ClienteDto nomeCliente){
		this.clienteDto=nomeCliente;
		

	}
	
	public final void dispatch() throws RestException{
		Rest rest = FenixFramework.getRoot();
		
		final Cliente cliente = rest.procuraClientePorNome(clienteDto.getNome());

		if(cliente.hasComprasAberta()){
			cliente.removeCompra(cliente.getCompraAberta());
		}
		
	}

	
	
}
