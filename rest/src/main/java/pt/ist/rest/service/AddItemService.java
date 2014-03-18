package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.RestauranteDto;


public class AddItemService extends RestService{
	
	private String username;

	public AddItemService(String username){
		this.username = username;
	}
	
	private DtoItemCompra result;
   
	public final void dispatch(){
		Rest rest = FenixFramework.getRoot();
		
		
	}
	
}