package pt.ist.rest.exception;

public class ClientAlreadyLikesDishException extends RestException{
	
	private static final long serialVersionUID = 1L;
	private final String clientName;
	private final String dishName;
	
	public ClientAlreadyLikesDishException (String clientName, String dishName){
		this.clientName=clientName;
		this.dishName = dishName;
		
	}

	public String getClientName(){
		return this.clientName;
	}
	public String getDishName(){
		return this.dishName;
	}

	public String toString(){
		return "The client: " + this.getClientName() +  " already likes dish :" + this.getDishName();
	}
	
}
