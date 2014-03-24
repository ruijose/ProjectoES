package pt.ist.rest.presentationserver;

import pt.ist.rest.service.dto.*;

public class RestaurantPresenter {

	public static void show(RestDto dto){
		for(RestauranteSimpleDto restaurante: dto.getRestaurantes()){
			restaurante.toString(); 
		}
	}
	
}
