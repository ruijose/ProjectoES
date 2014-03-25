package pt.ist.rest.exception;

public class DishNotFoundException extends RestException{
	private static final long serialVersionUID = 1L;
	
	private final String dishName;
	private final String restaurantName;
	
	public  DishNotFoundException (String dishName, String restaurantName){
		this.dishName=dishName;	
		this.restaurantName = restaurantName;
	}

	public DishNotFoundException(String restaurantName){
		this.restaurantName = restaurantName;
	}
	
	public String getDishName(){
		return this.dishName;
	}
	public String getRestaurantName(){
		return this.restaurantName;
	}

	public String toString(){
		return "The dish with name: " + this.getDishName() +  " was not found in restaurant: " + this.getRestaurantName();
	}

	public String toString2(){
		return "The restaurant: " + this.getRestaurantName() + " has no dishes.";
	}
	
}
