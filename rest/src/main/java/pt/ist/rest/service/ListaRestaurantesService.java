package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;

public class ListaRestaurantesService extends RestService {

	public ListaRestaurantesService() {
		   
		
	}
	
	
	public final void dispatch() {
		Rest rest = FenixFramework.getRoot();
		
		if (rest.getRestauranteCount() == 0)
			System.out.println("nao ha restaurantes registados");
		
		for (Restaurante r: rest.getRestauranteSet()) 
			 r.toString2();
	}
	
	
}