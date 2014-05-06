<<<<<<< HEAD
package pt.ist.rest.presentation.client;

import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratosDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RestServletAsync {
	
	 void initServer(String serverType, AsyncCallback<Void> callback);
	 
	 void login(ClienteDto user, AsyncCallback<Void> callback)  throws ArgumentosInvalidosException, ClientNotFoundException;
	 
	 void listaRestaurantes(AsyncCallback<List<RestauranteSimpleDto>> callback);
	 
	 void listaMenu(RestauranteSimpleDto r, AsyncCallback<List<PratoDto>> callback);
	 
	 void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quantidade,AsyncCallback<Void> callback) 
			 throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	 
	 void listaTabuleiro(ClienteDto c, AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
	
	 void efectuaPagamento(PagamentoDto dto,AsyncCallback<Void> callback);

	void procuraPrato(PratoSimpleDto p, AsyncCallback<PratosDto> asyncCallback);		 
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
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RestServletAsync {
	
	 void initServer(AsyncCallback<Void> callback);
	 void login(ClienteDto user, AsyncCallback<Void> callback)  throws ArgumentosInvalidosException, ClientNotFoundException;
	 void listaRestaurantes(AsyncCallback<List<RestauranteSimpleDto>> callback);
	 void listaMenu(RestauranteSimpleDto r, AsyncCallback<List<PratoDto>> callback);
	 void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quantidade,AsyncCallback<Void> callback) 
			 throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	 void listaTabuleiro(ClienteDto c, AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
	
	void getCustoTotil(ClienteDto c,AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
	 
	 
	 void efectuaPagamento(PagamentoDto dto,AsyncCallback<Void> callback);		 
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
import pt.ist.rest.service.dto.PagamentoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RestServletAsync {
	
	 void initServer(String serverType, AsyncCallback<Void> callback);
	 void login(ClienteDto user, AsyncCallback<Void> callback)  throws ArgumentosInvalidosException, ClientNotFoundException;
	 void listaRestaurantes(AsyncCallback<List<RestauranteSimpleDto>> callback);
	 void listaMenu(RestauranteSimpleDto r, AsyncCallback<List<PratoDto>> callback);
	 void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quantidade,AsyncCallback<Void> callback) 
			 throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	 void listaTabuleiro(ClienteDto c, AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
	
	void getCustoTotil(ClienteDto c,AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
	 
	 
	 void efectuaPagamento(PagamentoDto dto,AsyncCallback<Void> callback);		 
}	
>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
