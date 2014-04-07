package pt.ist.rest.presentation.server;


import java.util.List;



import pt.ist.rest.DatabaseBootstrap;
import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.presentation.client.RestServlet;
import pt.ist.rest.presentation.shared.FieldVerifier;
import pt.ist.rest.service.ListaRestaurantesService;
import pt.ist.rest.service.VerificaPassClienteService;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.UtilizadorDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.ListaMenuService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RestServletImpl extends RemoteServiceServlet implements
        RestServlet {
	
	private static final long              serialVersionUID = 1L;
	
	@Override
	public void initServer(){
		DatabaseBootstrap.init();
		DatabaseBootstrap.setup();
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
	public List<PratoDto> mostraMenu(RestauranteSimpleDto r) {
		System.out.println(r.getNome());
		ListaMenuService service = new ListaMenuService(r);
		service.execute();
		return service.getResult().getPratos();
	    }

}
