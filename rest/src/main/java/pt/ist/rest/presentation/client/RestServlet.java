<<<<<<< HEAD
package pt.ist.rest.presentation.client;


import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.service.dto.PratosDto;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface RestServlet extends RemoteService {
	
	void initServer(String serverType);
	
	void login(ClienteDto user) throws ArgumentosInvalidosException, ClientNotFoundException;
	
	List<RestauranteSimpleDto> listaRestaurantes();
	
	List<PratoDto> listaMenu(RestauranteSimpleDto r);
	
	void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quuantidade) 
			throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	
	TabuleiroDto listaTabuleiro(ClienteDto c) throws EmptyShoppingTrayException;
	
	void efectuaPagamento(PagamentoDto dto);

	PratosDto procuraPrato(PratoSimpleDto p);
}
||||||| merged common ancestors
package pt.ist.rest.presentation.client;


import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.TabuleiroDto;
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
	List<PratoDto> listaMenu(RestauranteSimpleDto r);
	void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quuantidade) 
			throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	TabuleiroDto listaTabuleiro(ClienteDto c) throws EmptyShoppingTrayException;
	TabuleiroDto getCustoTotil(ClienteDto c) throws EmptyShoppingTrayException;
	
	void efectuaPagamento(PagamentoDto dto);
}
=======
package pt.ist.rest.presentation.client;


import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("service")
public interface RestServlet extends RemoteService {
	
	void initServer(String serverType);
	void login(ClienteDto user) throws ArgumentosInvalidosException, ClientNotFoundException;
	List<RestauranteSimpleDto> listaRestaurantes();
	List<PratoDto> listaMenu(RestauranteSimpleDto r);
	void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quuantidade) 
			throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	TabuleiroDto listaTabuleiro(ClienteDto c) throws EmptyShoppingTrayException;
	TabuleiroDto getCustoTotil(ClienteDto c) throws EmptyShoppingTrayException;
	void efectuaPagamento(PagamentoDto dto);
}
>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
