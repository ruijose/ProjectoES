package pt.ist.rest.presentationserver;

import pt.ist.rest.service.dto.*;

public class MenuPresenter {
	
	public static void show(RestauranteDto dto){
		for(PratoDto prato: dto.getPratos()){
			prato.toString(); 
		}
	}
	
}
