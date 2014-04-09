package pt.ist.rest.presentation.client.view;

import java.util.List;

import pt.ist.rest.exception.ArgumentosInvalidosException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.DishNotFoundException;
import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.rest.exception.NoRestaurantsException;
import pt.ist.rest.exception.RestaurantNotFoundException;
import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.ItemDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.PratoSimpleDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;



public class AlterarQuantidadePanel extends FlexTable{


	  private final RestServletAsync rpcService;
	  private ClienteDto loggedPerson = null;
	  private RestGWT rootPage;

	  public AlterarQuantidadePanel(RestGWT rootPage, RestServletAsync rpcService) {
		  
		  
		  
	    GWT.log("presentation.client.view.AlterarQuantidadePanel::constructor()");
	    // set RPC service
	    this.rpcService = rpcService;
	    // format table main features:
	    addStyleName("contactsTable");
	    // add header row:
	    setText(0, 0,"Item");
	    setText(0, 1, "");
	    setText(0,2,"Quantidade");
	    setText(0,3,"");
	    setText(0,4,"");
	    setText(0, 5, "Preco");

	    // add style to row:
	    getRowFormatter().addStyleName(0,"quantidadesTableHeader");
	    //
	    this.rootPage = rootPage;
	  }
	  
	  public final void setLoggedPerson(ClienteDto dto) {
		  this.loggedPerson = dto;
	  }

	  public void add(ItemDto item) {
	    GWT.log("presentation.client.view.AlterarQuantidadePanel::add(" + item + ")");
	    final String  nomePrato = item.getNomePrato();
	    final RestauranteSimpleDto restaurante= item.getRestaurante();
	    final int  row = getRowCount();
	 
	    final Button plusButton = new Button("+");
	    final Button minusButton = new Button("-");
	    final CustomLabel quantidadeLabel = new CustomLabel(Integer.toString(item.getQuantidade()));
	    final Button confirmButton = new Button("confirmar");
	    
	    plusButton.addClickHandler(new ClickHandler(){
	    	
	    	@Override
	    	public void onClick(ClickEvent e){
	    		quantidadeLabel.addOne();
	    	}
	    	
	    });
	      
	    confirmButton.addClickHandler(new ClickHandler() {
	    	
	   
	    	final private CustomLabel label = quantidadeLabel;
	    	final private PratoSimpleDto prato = new PratoSimpleDto(nomePrato);
	    	
	    	@Override
	    	public void onClick(ClickEvent e){
	    		final int newQuantidade = Integer.parseInt(label.getText())- label.getDefaultValue();
	    		
	    		rpcService.alteraQuantidade(loggedPerson,prato,restaurante,newQuantidade, new AsyncCallback<Void>() {
	    			@Override
	    			public void onSuccess(Void response) {
	    				rootPage.showErrorMessage("Quantidade mudada com sucesso.");
	    			}

	    			@Override
	    			public void onFailure(Throwable caught) {
	    				GWT.log("presentation.client.view::ContactListPanel.rpcService.removeContact");
	    				GWT.log("-- Throwable: '" + caught.getClass().getName() + "'");
		    			rootPage.showErrorMessage("Houve um problema com a operacao, por favor tente de novo.");
		    			assert !(caught instanceof ClientNotFoundException) : "The client should be logged";
		    			assert !(caught instanceof RestaurantNotFoundException) :"The dishes should belong to a existing restaurant.";
		    			assert !(caught instanceof DishNotFoundException) : "The displayed dish existed at the time it was presented.";
	    			}
	    		});
	    	}
	    });
	  	    	   
	    minusButton.addClickHandler(new ClickHandler() {
	    	
	    	@Override
	    	public void onClick(ClickEvent e){
	    		quantidadeLabel.subOne();
	    	}
	    	
	    	
	    });
	    
	   
	    
	    setText(row, 0, item.getNomePrato());
	    setWidget(row, 1, plusButton);
	    setWidget(row,2,quantidadeLabel);
	    setWidget(row,3,minusButton);
	    setWidget(row,4,confirmButton);
	    setText(row, 5, Integer.toString(item.getPreco()));
	    
	    
	    // if we want alternate colored rows:
	    if ((row % 2) == 0) {
		getRowFormatter().addStyleName(row, "tableCellEven");
	    } else {
		getRowFormatter().addStyleName(row, "tableCellOdd");
	    }

	  }

	  public void clearList(){
		  GWT.log("presentation.client.view.AlterarQuantidadePanel::clearItemList()");
		  int rowCount = getRowCount();

		  for (int i = rowCount - 1; i > 0; i--)
			  removeRow(i);
	  }
	  class CustomLabel extends Label{
		  private int defaultValue;
		  public CustomLabel(String name){
		  	super(name);
		  	defaultValue = Integer.parseInt(name);
		  }
		  public int getDefaultValue(){
			  return defaultValue;
		  }
		  public void addOne(){
			  String newLabelText = Integer.toString(Integer.parseInt(super.getText())+1);
			  super.setText(newLabelText);
		  }
		  public void subOne(){
			  String newLabelText = Integer.toString(Integer.parseInt(super.getText())-1);
			  super.setText(newLabelText);
		  }
	  }
	  
}
