package pt.ist.rest.presentation.client.view;


import pt.ist.rest.presentation.client.RestGWT;
import pt.ist.rest.presentation.client.RestServletAsync;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PratoDto;
import pt.ist.rest.service.dto.RestauranteDto;
import pt.ist.rest.service.dto.RestauranteSimpleDto;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.core.client.GWT;

public class MostraMenuPanel extends FlexTable {

  private final RestServletAsync rpcService;
  private ClienteDto loggedPerson;
  private RestGWT rootPage;

  public MostraMenuPanel(RestServletAsync rpcService, RestGWT rootPage) {
    GWT.log("presentation.client.view.ContactListPanel::constructor()");
    // set RPC service
    this.rpcService = rpcService;
    // format table main features:
    addStyleName("contactsTable");
    // add header row:
    setText(0, 0, "Nome Prato");
    setText(0, 1, "Calorias");
    setText(0, 2, "Preco");
    setText(0, 3, "Classificacao");

    // add style to row:
    getRowFormatter().addStyleName(0, "contactsTableHeader");
    //
    this.rootPage = rootPage;
  }
  
  public final void setLoggedPerson(ClienteDto dto) {
	  this.loggedPerson = dto;
  }

  public void clearMenu() {
    GWT.log("presentation.client.view.ContactListPanel::clearContactList()");
    int rowCount = getRowCount();

    for (int i = rowCount - 1; i > 0; i--)
      removeRow(i);
  }

  public void add(PratoDto p) {
    
    GWT.log("presentation.client.view.ContactListPanel::add(" + p + ")");
    // get the number of the next row:
    int row = getRowCount();

    // add name and phone number (and set style from CSS)
  
      setText(row, 0, p.getNome());
      setText(row, 1, ((Integer)p.getCalorias()).toString());
      setText(row, 2, ((Integer)p.getPreco()).toString());
      setText(row, 3, ((Integer)p.getClassificacao()).toString());
   
    // if we want styles across columns (and data type):
    getCellFormatter().addStyleName(row, 0, "contactsTableNameCell");
    getCellFormatter().addStyleName(row, 1, "contactsTablePhoneCell");
    
    // if we want alternate colored rows:
    if ((row % 2) == 0) {
	getRowFormatter().addStyleName(row, "contactsTableCellEven");
    } else {
	getRowFormatter().addStyleName(row, "contactsTableCellOdd");
    }
  }

}