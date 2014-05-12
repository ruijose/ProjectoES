package pt.ist.rest.presentation.server;


import java.util.List;

import pt.ist.registofatura.RegistoFaturaLocal;
import pt.ist.registofatura.ws.EmissorInexistente_Exception;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.ChequeRefeicaoLocal;
import pt.ist.rest.DatabaseBootstrap;
import pt.ist.rest.exception.*;
import pt.ist.rest.presentation.client.RestServlet;
import pt.ist.rest.presentation.shared.FieldVerifier;
import pt.ist.rest.service.*;
import pt.ist.rest.service.dto.*;
;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RestServletImpl extends RemoteServiceServlet implements
        RestServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String localServerType = "ES-only";
	private static final String remoteServerType = "ES+SD";
	@Override
	public void initServer(String serverType){
		DatabaseBootstrap.init();
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
		
	@Override
	public PratosDto procuraPrato(PratoSimpleDto p){
		ProcuraPratoService service = new ProcuraPratoService(p);
		service.execute();
		return service.getResult();
		
	}

	@Override
 	public void adicionaCheques(ChequesDto cheques) throws pt.ist.rest.exception.InvalidCheckException,
 														pt.ist.rest.exception.CheckAlreadyUsedException, 
 														ClientNotFoundException {
 		new ActualizaSaldoService(cheques).execute();
 	}
 	
 	
 	@Override
 	public void efectuaPagamento(ClienteDto cliente) throws NegativeBalanceException, 
 															EmptyShoppingTrayException, 
 															ClientNotFoundException{
 		new RegistaPagamentoTabuleiroComprasService(cliente).execute();
 		new ComunicaFaturaService(cliente).execute();
 	}
} 
