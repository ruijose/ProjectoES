package pt.ist.rest.presentation.client;



import java.util.*;


import pt.ist.rest.exception.NoRestaurantsException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.presentation.client.view.ListaRestaurantesPanel;
import pt.ist.rest.presentation.client.view.RestaurantesPresenterPanel;
import pt.ist.rest.presentation.client.view.MostraMenuPanel;
import pt.ist.rest.service.dto.RestauranteSimpleDto;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.UtilizadorDto;
import pt.ist.rest.service.dto.PratoDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MenuPage extends Composite {

	private final Button refreshButton = new Button("Refresh");
	private final Button logOutButton = new Button("Logout");
	
	private final ListaRestaurantesPanel listaRestaurantesPanel;
	private final RestaurantesPresenterPanel restaurantePresenterPanel = new RestaurantesPresenterPanel();
	
	
    private ClienteDto loggedPerson;
	
	private RestServletAsync rpcService;
	
	private RestGWT rootPage;
	
	
	// Create a generic handler that gets data and calls createContact
		class MyHandler {
			// Send the request to server
			protected void sendRequestToServer() {
				listaRestaurantes();
			}
		}
	
		// Create a handler for clicks
		class MyClickHandler extends MyHandler implements ClickHandler {
			// Fired when the user clicks on the related button
			public void onClick(ClickEvent event) {
				sendRequestToServer();
			}
		}


	
	public MenuPage(final RestGWT rootPage, final RestServletAsync rpcService) {				
		this.rpcService = rpcService;
		this.rootPage = rootPage;
		
		listaRestaurantesPanel = new ListaRestaurantesPanel(rpcService, rootPage);
		
		refreshButton.setStyleName("refreshListButton");
		
		logOutButton.setStyleName("logoutListButton");
		logOutButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	
            	rootPage.showLoginPage();
            }
	});
		
		
		this.restaurantePresenterPanel.setClickHandlerRestaurantes(new MyClickHandler());
    }
	
	void listaRestaurantes(){

		rpcService.listaRestaurantes(new AsyncCallback<List<RestauranteSimpleDto>>() {
			
			
			public void onSuccess(List<RestauranteSimpleDto> response) {
				
				listaRestaurantesPanel.clearRestaurantList();
				final RootPanel listRootPanel = RootPanel.get("contactsListContainer");
				listRootPanel.clear();
				listRootPanel.add(listaRestaurantesPanel);
				
				for(RestauranteSimpleDto r : response){
					listaRestaurantesPanel.add(r);
				}
				
			}

			public void onFailure(Throwable caught) {
				GWT.log("presentation.client.PhoneBook::onModuleLoad()::rpcService.createContact");
				GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
				if (caught instanceof NoRestaurantsException) {
					rootPage.showErrorMessage("No restaurants found");
				} else {
					Window.alert("ERROR: Cannot list contacts: " + caught.getMessage());
				}
			}
		});
	}


	
	
	
	// show this page
		void showPage(ClienteDto loggedClient) {
			this.loggedPerson = loggedClient;
			
			listaRestaurantesPanel.setLoggedPerson(loggedPerson);
			
			RootPanel formRootPanel = RootPanel.get("menuAddContainer");
			formRootPanel.add(restaurantePresenterPanel);
			restaurantePresenterPanel.setWidth("100%");

			RootPanel listRootPanel = RootPanel.get("contactsListContainer");
			listRootPanel.add(listaRestaurantesPanel);
			listaRestaurantesPanel.setWidth("100%");

			RootPanel refreshRootPanel = RootPanel.get("refresh");
			refreshRootPanel.add(refreshButton);
			
			RootPanel logoutRootPanel = RootPanel.get("logout");
			logoutRootPanel.add(logOutButton);
		}
		
		// hide this page
		void hidePage() {
			RootPanel.get("menuAddContainer").clear();
			RootPanel.get("contactsListContainer").clear();
			RootPanel.get("refresh").clear();
			RootPanel.get("logout").clear();
		}
	
}
