<<<<<<< HEAD
package pt.ist.rest.presentationserver;

import pt.ist.rest.service.dto.*;

public class MenuPresenter {
	
	public static String show(RestauranteDto dto){
		String result = "";
		for(PratoDto prato: dto.getPratos()){
			result += prato.getAtributo() + "|" + prato.getPreco() + "|" + prato.getCalorias() + "|"; 
		}
		return result;
	}
	
}
||||||| merged common ancestors
package pt.ist.rest.presentationserver;

import pt.ist.rest.service.dto.*;

public class MenuPresenter {
	
	public static String show(RestauranteDto dto){
		String result = "";
		for(PratoDto prato: dto.getPratos()){
			result += prato.getNome() + "|" + prato.getPreco() + "|" + prato.getCalorias() + "|"; 
		}
		return result;
	}
	
}
=======
package pt.ist.rest.presentationserver;

import pt.ist.rest.service.dto.*;

public class MenuPresenter {
	
	public static String show(RestauranteDto dto){
		String result = "";
		for(PratoDto prato: dto.getPratos()){
			result += prato.getNome() + "|" + prato.getPreco() + "|" + prato.getCalorias() + "|"; 
		}
		return result;
	}
	
}
>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
