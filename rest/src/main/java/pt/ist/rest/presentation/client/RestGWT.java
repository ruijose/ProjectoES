package pt.ist.rest.presentation.client;



import pt.ist.rest.presentation.client.LoginPage;
import pt.ist.rest.presentation.shared.FieldVerifier;
import pt.ist.rest.service.dto.ClienteDto;
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
	
	private final Label serverTypeLabel = new Label("Rest - local Mode");
	
	private final RestServletAsync rpcService = GWT
			.create(RestServlet.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		serverTypeLabel.setStyleName("h1");
		serverTypeLabel.setWidth("100%");

		loginPage = new LoginPage(this, rpcService);
		menuPage = new MenuPage(this, rpcService);
		
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
	
	void showLoginPage() {
		menuPage.hidePage();
        
		RootPanel.get("menuAddContainer").add(loginPage);
		
        errorMessage.setText("");
	}
	
	// show the contact page of the logged person
	void showMenuPage(ClienteDto loggedClient) {
		
		RootPanel.get("menuAddContainer").clear();
			
		menuPage.showPage(loggedClient);
			
		errorMessage.setText("");
	}
	
	public void showErrorMessage(String message) {
		errorMessage.setText(message);
	}
  }
