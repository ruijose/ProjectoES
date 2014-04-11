package pt.ist.rest.presentation.client;



import java.util.List;

import pt.ist.chequerefeicao.CheckAlreadyUsedException;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.ChequeRefeicaoLocal;
import pt.ist.chequerefeicao.InvalidCheckException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.NegativeBalanceException;
import pt.ist.rest.presentation.client.LoginPage;
import pt.ist.rest.presentation.client.view.MenuOptionsPanel;
import pt.ist.rest.service.ActualizaSaldoService;
import pt.ist.rest.service.RegistaPagamentoTabuleiroComprasService;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RestGWT implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	private static final String localServerType = "ES-only";
	private static final String remoteServerType = "ES+SD";
	
	private final Label errorMessage = new Label("");
	private LoginPage loginPage;
	private MenuPage menuPage;
	private RestaurantePage restaurantePage;
	private TabuleiroPage tabuleiroPage;

	
	private final RestServletAsync rpcService = GWT
			.create(RestServlet.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// create label with mode type
		String serverType; // depends on type of running
		if (RootPanel.get(remoteServerType) != null) {
			GWT.log("presentation.client.Rest::onModuleLoad() running on remote mode");
			serverType = remoteServerType;
		} else { // default: local - even if it is misspelled
			GWT.log("presentation.client.Rest::onModuleLoad() running on local mode");
			serverType = localServerType;
		}

		GWT.log("presentation.client.RestGWT::onModuleLoad() - begin");
		
		loginPage = new LoginPage(this, rpcService);
		menuPage = new MenuPage(this, rpcService);
		restaurantePage = new RestaurantePage(this,rpcService);
		tabuleiroPage = new TabuleiroPage(this,rpcService);
		

		this.rpcService.initServer(serverType,new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
			}
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("presentation.client.rest::onModuleLoad()::rpcService.initBridge");
				GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
				showErrorMessage("Not able to init aplication server bridge: " + caught.getMessage());
			}
		});
		
		RootPanel updateRootPanel = RootPanel.get("labelError");
        updateRootPanel.add(errorMessage);
        errorMessage.setStyleName("labelError");
        errorMessage.setWidth("100%");
  
		showLoginPage();	
	}
	
	public void addOptionsView(final ClienteDto dto,MenuOptionsPanel options){
		RootPanel formRootPanel = RootPanel.get("menuAddContainer");
		formRootPanel.clear();
		formRootPanel.add(options);
		options.setWidth("100%");
		
		options.setClickHandlerRestaurantes(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent e){
        		showRestaurantePage(dto);
        	}
        });
        options.setClickHandlerTabuleiro(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent e){
        		showTabuleiroPage(dto);
        	}
        });	
	}
	
	public void showLoginPage() {
		this.clearPage();
		RootPanel.get("menuAddContainer").add(loginPage);
	}
	public void showMenuPage(ClienteDto loggedClient, RestauranteSimpleDto restDto) {
		this.clearPage();
		menuPage.showPage(loggedClient,restDto);
	}
	
	public void showRestaurantePage(ClienteDto loggedClient){
		this.clearPage();
		restaurantePage.showPage(loggedClient);
	}
	public void showTabuleiroPage(ClienteDto loggedClient){
		this.clearPage();
		tabuleiroPage.showPage(loggedClient);
	}


	public void clearPage() {
		RootPanel.get("menuAddContainer").clear();
		RootPanel.get("contactsListContainer").clear();
		RootPanel.get("refresh").clear();
		RootPanel.get("logout").clear();
		errorMessage.setText("");
	}
	
	public void showSuccessMessage(String message){
		errorMessage.getElement().getStyle().setProperty("color", "green");
		errorMessage.setText(message);
	}
	
	public void showErrorMessage(String message) {
		errorMessage.getElement().getStyle().setProperty("color", "red");
		errorMessage.setText(message);
	}
  }
