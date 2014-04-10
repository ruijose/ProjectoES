package pt.ist.rest.presentation.client;

import java.util.List;

import pt.ist.rest.exception.NoRestaurantsException;
import pt.ist.rest.presentation.client.view.ListaRestaurantesPanel;
import pt.ist.rest.presentation.client.view.MenuOptionsPanel;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

public class RestaurantePage extends Composite{

	private final Button refreshButton = new Button("Refresh");
	private final Button logOutButton = new Button("Logout");
	
    private ClienteDto loggedPerson;
	private RestServletAsync rpcService;
	private RestGWT rootPage;
	
	
	private final ListaRestaurantesPanel listaRestaurantesPanel;

	
	public RestaurantePage(final RestGWT rootPage, final RestServletAsync rpcService) {				
		this.rpcService = rpcService;
		this.rootPage = rootPage;

		listaRestaurantesPanel = new ListaRestaurantesPanel(rpcService, rootPage);
		
		refreshButton.setStyleName("refreshListButton");

		logOutButton.setStyleName("logoutListButton");
		refreshButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				rootPage.showRestaurantePage(loggedPerson);
			}
		});
		logOutButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	
            	rootPage.showLoginPage();
            }
	
		});
		
		
	  
	}
	
	void showPage(final ClienteDto loggedClient) {
		this.loggedPerson = loggedClient;

		listaRestaurantesPanel.setLoggedPerson(loggedPerson);
		
		this.rootPage.addOptionsView(loggedClient,new MenuOptionsPanel(this.rootPage));

		//Refresh the view
		this.listaRestaurantes();

		RootPanel refreshRootPanel = RootPanel.get("refresh");
		refreshRootPanel.add(refreshButton);

		RootPanel logoutRootPanel = RootPanel.get("logout");
		logoutRootPanel.add(logOutButton);
		
	
	}

	
	/*
	 *	Handlers for RestaurantePage   
	 **/
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
				GWT.log("presentation.client.RestaurantePage::listaRestaurantes()::rpcService.listaRestaurantes");
				GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
				if (caught instanceof NoRestaurantsException) {
					rootPage.showErrorMessage("No restaurants found");
				} else {
					Window.alert("ERROR: Cannot list Restaurants: " + caught.getMessage());
				}
			}
		});
	}
	/*
	public final void verMenuDeRestaurante(RestauranteSimpleDto dto){
		this.rootPage.showMenuPage(this.loggedPerson, dto);
	}
	*/
	
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

	
}
