package pt.ist.rest.presentation.server;


import java.util.List;

import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.ChequeRefeicaoLocal;
import pt.ist.rest.DatabaseBootstrap;
import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.presentation.client.RestServlet;
import pt.ist.rest.service.AddItemService;
import pt.ist.rest.service.ListaRestaurantesService;
import pt.ist.rest.service.ListaTabuleiroService;
import pt.ist.rest.service.VerificaPassClienteService;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.TabuleiroDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.ListaMenuService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RestServletImpl extends RemoteServiceServlet implements
        RestServlet {
	
	private static final long              serialVersionUID = 1L;
	
	private static final String localServerType = "ES-only";
	private static final String remoteServerType = "ES+SD";
	
	@Override
	public void initServer(String serverType){
		DatabaseBootstrap.init();
		DatabaseBootstrap.setup();
		if (serverType.equals(localServerType))
			ChequeRefeicao.setCheque(new ChequeRefeicaoLocal());
	};
	
	@Override
	  public void login(ClienteDto cliente) throws ArgumentosInvalidosException, ClientNotFoundException {
	    VerificaPassClienteService service = new VerificaPassClienteService(cliente);
	    service.execute();
	  }
	
	@Override
	public List<RestauranteSimpleDto> listaRestaurantes() {
		ListaRestaurantesService service = new ListaRestaurantesService();
		service.execute();
		return service.getResult().getRestaurantes();
	  }

	@Override
	public List<PratoDto> listaMenu(RestauranteSimpleDto r) {
		ListaMenuService service = new ListaMenuService(r);
		service.execute();
		return service.getResult().getPratos();
	    }
	
	@Override
	public void adicionaItem(ClienteDto c, PratoSimpleDto p, RestauranteSimpleDto r, int quantidade)
			throws ClientNotFoundException,RestaurantNotFoundException,DishNotFoundException {
		AddItemService service = new AddItemService(c,p,r,quantidade);
		service.execute();
	}

	@Override
	public TabuleiroDto listaTabuleiro(ClienteDto c)
		throws EmptyShoppingTrayException{
		ListaTabuleiroService service = new ListaTabuleiroService(c);
		service.execute();
		return service.getResult();
		
	}
	
}
