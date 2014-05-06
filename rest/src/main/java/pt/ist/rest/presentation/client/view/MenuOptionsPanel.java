<<<<<<< HEAD
package pt.ist.rest.presentation.client.view;

import pt.ist.rest.presentation.client.RestGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuOptionsPanel extends DecoratorPanel {

  private final VerticalPanel verticalPanel;

  private TextBox textBoxCheque;
  private TextBox textBoxPrato;
  private final Button listaRestauranteButton;
  private final Button mostrarTabuleiroButton;
  private final Button efectuarPagamentoButton;
  private final Button procuraPratoButton;

  
  public MenuOptionsPanel(RestGWT rootPanel) {
    GWT.log("presentation.client.view.CreateContactPanel::constructor()");

    this.verticalPanel = new VerticalPanel();

    Label lblUser = new Label("Introduza o numero de cheque:");
    Label lblPrato = new Label("Introduza o tipo ou o nome do prato:");
    lblUser.setStyleName("label");
    lblPrato.setStyleName("label");
    this.textBoxCheque = new TextBox();
    this.textBoxPrato = new TextBox();
    this.listaRestauranteButton = new Button("Lista Restaurantes");
    this.mostrarTabuleiroButton = new Button("Mostrar Tabuleiro"); 
    this.efectuarPagamentoButton = new Button ("Pagar");
    this.procuraPratoButton = new Button("Procura Prato");
    this.verticalPanel.add(this.listaRestauranteButton);
    this.verticalPanel.add(this.mostrarTabuleiroButton);

    this.verticalPanel.add(lblPrato);
    this.verticalPanel.add(this.textBoxPrato);
    this.verticalPanel.add(this.procuraPratoButton);

    this.verticalPanel.add(lblUser);
    this.verticalPanel.add(this.textBoxCheque);
    this.verticalPanel.add(this.efectuarPagamentoButton);
    
    this.add(this.verticalPanel);
 
    
  }

  public void setClickHandlerRestaurantes(ClickHandler handler) {
	    this.listaRestauranteButton.addClickHandler(handler);
  }
  public void setClickHandlerTabuleiro(ClickHandler handler){
	  this.mostrarTabuleiroButton.addClickHandler(handler);
  }
    
  public void setClickHandlerEfectuarPagamento(ClickHandler handler){
	  this.efectuarPagamentoButton.addClickHandler(handler);
  }
  
  public void setClickHandlerEfectuarPesquisa(ClickHandler handler){
	  this.procuraPratoButton.addClickHandler(handler);
  }
  
  public TextBox getChequeBox(){
	  return this.textBoxCheque;
  }
  
  public TextBox getPratoBox(){
	  return this.textBoxPrato;
  }
||||||| merged common ancestors
package pt.ist.rest.presentation.client.view;

import pt.ist.rest.presentation.client.RestGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuOptionsPanel extends DecoratorPanel {

  private final VerticalPanel verticalPanel;

  private TextBox textBoxCheque;
  private final Button listaRestauranteButton;
  private final Button mostrarTabuleiroButton;
  private final Button alterarQuantidadeButton;
  private final Button efectuarPagamentoButton;

  
  public MenuOptionsPanel(RestGWT rootPanel) {
    GWT.log("presentation.client.view.CreateContactPanel::constructor()");

    this.verticalPanel = new VerticalPanel();

    Label lblUser = new Label("Introduza o numero de cheque:");
    lblUser.setStyleName("label");
    this.textBoxCheque = new TextBox();
    this.listaRestauranteButton = new Button("Lista Restaurantes");
    this.mostrarTabuleiroButton = new Button("Mostrar Tabuleiro"); 
    this.alterarQuantidadeButton = new Button ("Alterar Quantidade");
    this.efectuarPagamentoButton = new Button ("Pagar");
    this.verticalPanel.add(this.listaRestauranteButton);
    this.verticalPanel.add(this.mostrarTabuleiroButton);
    this.verticalPanel.add(this.alterarQuantidadeButton);
    this.verticalPanel.add(lblUser);
    this.verticalPanel.add(this.textBoxCheque);
    this.verticalPanel.add(this.efectuarPagamentoButton);
    this.add(this.verticalPanel);
 
    
  }

  public void setClickHandlerRestaurantes(ClickHandler handler) {
	    this.listaRestauranteButton.addClickHandler(handler);
  }
  public void setClickHandlerTabuleiro(ClickHandler handler){
	  this.mostrarTabuleiroButton.addClickHandler(handler);
  }
  public void setClickHandlerAlterarQuantidade(ClickHandler handler){
	  this.alterarQuantidadeButton.addClickHandler(handler);
  }
    
  public void setClickHandlerEfectuarPagamento(ClickHandler handler){
	  this.efectuarPagamentoButton.addClickHandler(handler);
  }
  
  public TextBox getChequeBox(){
	  return this.textBoxCheque;
  }
=======
package pt.ist.rest.presentation.client.view;

import pt.ist.rest.presentation.client.RestGWT;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuOptionsPanel extends DecoratorPanel {

  private final VerticalPanel verticalPanel;

  private TextBox textBoxCheque;
  private final Button listaRestauranteButton;
  private final Button mostrarTabuleiroButton;
  private final Button efectuarPagamentoButton;

  
  public MenuOptionsPanel(RestGWT rootPanel) {
    GWT.log("presentation.client.view.CreateContactPanel::constructor()");

    this.verticalPanel = new VerticalPanel();

    Label lblUser = new Label("Introduza o numero de cheque:");
    lblUser.setStyleName("label");
    this.textBoxCheque = new TextBox();
    this.listaRestauranteButton = new Button("Lista Restaurantes");
    this.mostrarTabuleiroButton = new Button("Mostrar Tabuleiro"); 
    this.efectuarPagamentoButton = new Button ("Pagar");
    this.verticalPanel.add(this.listaRestauranteButton);
    this.verticalPanel.add(this.mostrarTabuleiroButton);
    this.verticalPanel.add(lblUser);
    this.verticalPanel.add(this.textBoxCheque);
    this.verticalPanel.add(this.efectuarPagamentoButton);
    this.add(this.verticalPanel);
 
    
  }

  public void setClickHandlerRestaurantes(ClickHandler handler) {
	    this.listaRestauranteButton.addClickHandler(handler);
  }
  public void setClickHandlerTabuleiro(ClickHandler handler){
	  this.mostrarTabuleiroButton.addClickHandler(handler);
  }
    
  public void setClickHandlerEfectuarPagamento(ClickHandler handler){
	  this.efectuarPagamentoButton.addClickHandler(handler);
  }
  
  public TextBox getChequeBox(){
	  return this.textBoxCheque;
  }
>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
}