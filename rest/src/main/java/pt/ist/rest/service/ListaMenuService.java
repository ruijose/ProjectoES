package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;

public class ListaMenuService extends RestService {

	
	private String nomeR;
	
	public ListaMenuService(String nomeRestaurante) {
		   this.nomeR = nomeRestaurante;
		
	}
	
	
	public final void dispatch() {
		Rest rest = FenixFramework.getRoot();
		
		Restaurante restaurante = rest.procuraRestaurantePorNome(nomeR);
		
		if (restaurante.getPratoCount() == 0)
			System.out.println("nao ha pratos do restaurante nomeR");
		
		for (Prato p: restaurante.getPratoSet()) 
			 p.toString();
	}
	
	
}