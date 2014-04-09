package pt.ist.rest.presentation.client;



import pt.ist.rest.presentation.client.LoginPage;
import pt.ist.rest.presentation.client.view.AlterarQuantidadePanel;
import pt.ist.rest.presentation.client.view.ListaRestaurantesPanel;
import pt.ist.rest.presentation.client.view.MenuOptionsPanel;
import pt.ist.rest.presentation.shared.FieldVerifier;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.UtilizadorDto;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

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

	private final Label errorMessage = new Label("");
	private LoginPage loginPage;
	private MenuPage menuPage;
	//private TabuleiroPage tabuleiroPage;
	private RestaurantePage restaurantePage;
	private AlterarQuantidadePage alterarQuantidadePage;
	
	private MenuOptionsPanel menuOptions;
	
	private final Label serverTypeLabel = new Label("Rest - local Mode");
	
	private final RestServletAsync rpcService = GWT
			.create(RestServlet.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		GWT.log("presentation.client.RestGWT::onModuleLoad() - begin");
		
		serverTypeLabel.setStyleName("h1");
		serverTypeLabel.setWidth("100%");
		
		loginPage = new LoginPage(this, rpcService);
		menuPage = new MenuPage(this, rpcService);
		restaurantePage = new RestaurantePage(this,rpcService);
	//	tabuleiroPage = new TabuleiroPage(this,rpcService);
		alterarQuantidadePage = new AlterarQuantidadePage(this,rpcService);
		
		
		this.rpcService.initServer(new AsyncCallback<Void>() {
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
	public void setOptionsView(MenuOptionsPanel mp){
		 this.menuOptions =  mp;
	}
	
	
	public void initWindow(final ClienteDto dto){
		menuOptions.setClickHandlerRestaurantes(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent e){
        		showRestaurantePage(dto);
        	}
        });
        menuOptions.setClickHandlerAlterarQuantidade(new ClickHandler() {
        	@Override
        	public void onClick(ClickEvent e){
        		showAlterarQuantidade(dto);
        	}
        });
		
	}
	
	public void addOptionsView(ClienteDto dto,MenuOptionsPanel options){
		setOptionsView(options);
		RootPanel formRootPanel = RootPanel.get("menuAddContainer");
		formRootPanel.clear();
		formRootPanel.add(options);
		options.setWidth("100%");
		initWindow(dto);
		
	}
	
	void showLoginPage() {
		menuPage.hidePage();
        
		RootPanel.get("menuAddContainer").add(loginPage);
		
        errorMessage.setText("");
	}
	void showRestaurantePage(ClienteDto loggedClient){
		menuPage.hidePage();
		RootPanel.get("menuAddContainer").clear();
		
		restaurantePage.showPage(loggedClient);
		
		errorMessage.setText("");
	}
	void showAlterarQuantidade(ClienteDto loggedClient){
		menuPage.hidePage();
		RootPanel.get("menuAddContainer").clear();
		
		alterarQuantidadePage.showPage(loggedClient);
		
		errorMessage.setText("");
		
	}


	/*
	void showTabuleiroPage(ClienteDto loggedClient){
		RootPanel.get("menuAddContainer").clear();

		tabuleiroPage.showTabulPage(loggedClient);

		errorMessage.setText("");
	}
	*/
	
	public void showErrorMessage(String message) {
		errorMessage.setText(message);
	}
  }
