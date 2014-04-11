package pt.ist.rest.presentation.client.view;

import pt.ist.rest.presentation.client.RestGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuOptionsPanel extends DecoratorPanel {

  private final VerticalPanel verticalPanel;

  private final Button listaRestauranteButton;
  private final Button mostrarTabuleiroButton;

  
  public MenuOptionsPanel(RestGWT rootPanel) {
    GWT.log("presentation.client.view.CreateContactPanel::constructor()");

    this.verticalPanel = new VerticalPanel();

    this.listaRestauranteButton = new Button("Lista Restaurantes");
    this.mostrarTabuleiroButton = new Button("Mostrar Tabuleiro"); 
    this.verticalPanel.add(this.listaRestauranteButton);
    this.verticalPanel.add(this.mostrarTabuleiroButton);
    this.add(this.verticalPanel);
 
    
  }

  public void setClickHandlerRestaurantes(ClickHandler handler) {
	    this.listaRestauranteButton.addClickHandler(handler);
  }
  public void setClickHandlerTabuleiro(ClickHandler handler){
	  this.mostrarTabuleiroButton.addClickHandler(handler);
  }
    
}