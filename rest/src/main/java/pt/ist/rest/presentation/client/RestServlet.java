package pt.ist.rest.presentation.client;


import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface RestServlet extends RemoteService {
	
	void initServer();
	void login(ClienteDto user) throws ArgumentosInvalidosException, ClientNotFoundException;
	List<RestauranteSimpleDto> listaRestaurantes();
	List<PratoDto> mostraMenu(RestauranteSimpleDto r);
}
