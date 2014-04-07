package pt.ist.rest.exception;

public class RestaurantNotFoundException extends RestException{
	private static final long serialVersionUID = 1L;
	private final String restaurantName;
	
	public RestaurantNotFoundException(String restaurantName){
		this.restaurantName=restaurantName;
	}

	public String getRestaurantName(){
		return restaurantName;
	}
	
	public String toString(){
		return "The restaurant with name: " + this.getRestaurantName() +  " was not found";
	}
}
