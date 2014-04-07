package pt.ist.rest.presentation.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RestaurantesPresenterPanel extends DecoratorPanel {

  private final VerticalPanel verticalPanel;

  private final Button listaRestauranteButton;

  public RestaurantesPresenterPanel() {
    GWT.log("presentation.client.view.CreateContactPanel::constructor()");

    this.verticalPanel = new VerticalPanel();

    this.listaRestauranteButton = new Button("Lista Restaurantes");
   
    this.verticalPanel.add(this.listaRestauranteButton);

    this.add(this.verticalPanel);
  }

  

  public void setClickHandlerRestaurantes(ClickHandler handler) {
	    this.listaRestauranteButton.addClickHandler(handler);
  }
  
 
  
}