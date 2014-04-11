package pt.ist.rest.presentation.client;

import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.service.dto.ClienteDto;
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
	
	 void initServer(String serverType,AsyncCallback<Void> callback);
	 void login(ClienteDto user, AsyncCallback<Void> callback)  throws ArgumentosInvalidosException, ClientNotFoundException;
	 void listaRestaurantes(AsyncCallback<List<RestauranteSimpleDto>> callback);
	 void listaMenu(RestauranteSimpleDto r, AsyncCallback<List<PratoDto>> callback);
	 void adicionaItem(ClienteDto c,PratoSimpleDto d, RestauranteSimpleDto r, int quantidade,AsyncCallback<Void> callback) 
			 throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException;
	 void listaTabuleiro(ClienteDto c, AsyncCallback<TabuleiroDto> callback)
			 throws EmptyShoppingTrayException;
}	
