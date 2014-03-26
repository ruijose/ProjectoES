package pt.ist.rest.domain;

import pt.ist.rest.exception.*;

public class Rest extends Rest_Base {
    
	 public  Rest() {
        super();
        setIDPrato(-1);
    }
	
	public int incrementaIDPrato(){
    	int ID = super.getIDPrato();
    	ID = ID + 1;
    	super.setIDPrato(ID);
    	return ID;  	
    	
    }
	
    @Override
    public void addCliente(Cliente c) throws ClientAlreadyExistsException{
		if (hasUtilizador(c))						
			throw new ClientAlreadyExistsException(c.getUsername());
		else
			super.addCliente(c);	  	
    }

    public void addRestaurante(Restaurante r,String nomeGestor) 
				throws RestaurantAlreadyExistsException, ManagerNotFoundException, BusyManagerException{
				
		final Gestor gestor = procuraGestorPorNome(nomeGestor);
		
		if (gestor == null)
			throw new ManagerNotFoundException(nomeGestor);
		if (hasRestaurante(r))
			throw new RestaurantAlreadyExistsException(r.getNome());
			
		r.addGestor(gestor);
		super.addRestaurante(r);
			
    }
    
    @Override
    public void addUtilizador(Utilizador u) throws UserAlreadyExistsException{
    	if(hasUtilizador(u))
    		throw new UserAlreadyExistsException(u.getUsername());			
    	else
    		super.addUtilizador(u);	    	
    }
   
    public Restaurante procuraRestaurantePorNome(String nome){
    	for(Restaurante r : getRestauranteSet()){
    	    if(r.getNome().equals(nome)) 
				return r;
        }
    	return null;
    }
	
	public void imprimeRestaurantes(){		
		for(Restaurante r: getRestauranteSet())
			System.out.println(r);
	}
	
	
	 public void imprimeUtilizadores(){				
 
		for (Restaurante r: getRestauranteSet()){
			for(Gestor g: r.getGestorSet())
				System.out.println(g);
        }
				
		for(Cliente c: getClienteSet())
				System.out.println(c);
	
	}
	public void clienteGostaDePrato(String username,String nomeRestaurante,String nomePrato)
				throws ClientNotFoundException, RestaurantNotFoundException, DishNotFoundException,
						 LikesNumberExceedException, ClientAlreadyLikesDishException{
				
		final Cliente cliente = procuraPratoEmRestaurante(username);
		if (cliente == null)
			throw new ClientNotFoundException(username);
			
		final Restaurante restaurante = procuraRestaurantePorNome(nomeRestaurante);
		if (restaurante == null)
			throw new RestaurantNotFoundException(nomeRestaurante);
			
		final Prato prato = procuraPratoEmRestaurante(nomeRestaurante,nomePrato);
		if (prato == null)
			throw new DishNotFoundException(nomePrato,nomeRestaurante);
		
		cliente.addGosto(prato);
	}
	
	public void adicionaPratoRestaurante(String usernameGestor, String nomeRestaurante, Prato novoPrato)
		throws RestaurantNotFoundException, ManagerNotFoundException, ManagerHasNoAccessException, DishesNumberExceedException{
		
		final Restaurante restaurante = procuraRestaurantePorNome(nomeRestaurante);
		if (restaurante == null)
			throw new RestaurantNotFoundException(nomeRestaurante);
		
		final Gestor gestor = procuraGestorPorNome(usernameGestor);
		final boolean GestorGereRestaurante = gestor.getRestaurante().equals(restaurante);
		if (!GestorGereRestaurante)
			throw new ManagerHasNoAccessException(gestor.getUsername());
				
		if (restaurante.hasGestor(usernameGestor))
			throw new ManagerNotFoundException(usernameGestor,nomeRestaurante);
	
		restaurante.adicionaPrato(novoPrato);

	}
	
	 public Prato procuraPratoEmRestaurante(String nomeRestaurante,String nome){
    	
    	final Restaurante r = procuraRestaurantePorNome(nomeRestaurante);

    	for(Prato p: r.getPratoSet()){
    		if(p.getNome().equals(nome))
    			return p;
        }

    	return null;
    }
	
    
    public int calculaClassificacao(String nomeRestaurante) throws RestaurantNotFoundException{
    	
		Restaurante restaurante = procuraRestaurantePorNome(nomeRestaurante);
		if (restaurante == null)
			throw new RestaurantNotFoundException(nomeRestaurante);
		else 
			return restaurante.calculaClassificacao();
    }
    
    public Cliente procuraPratoEmRestaurante(String nomeCliente){
    	for(Cliente c: getClienteSet()){
    		if(c.getUsername().equals(nomeCliente))
    		   return c;
		}
    	return null;
    }
	public Gestor procuraGestorPorNome(String usernameGestor){
		for (Restaurante r: getRestauranteSet()){
			for (Gestor g: r.getGestorSet()){
				if (g.getUsername().equals(usernameGestor))
					return g;
			}
		}
		return null;
	}

    
    
    @Override
	public boolean hasRestaurante(Restaurante restaurante){

		for (Restaurante r: getRestauranteSet()){
			if (r.equals(restaurante))
				return true;
        }
		return false;
	}
    
    public boolean hasRestaurante(String nomeRestaurante){
    	return procuraRestaurantePorNome(nomeRestaurante)!=null;
    }

    @Override
	public boolean hasUtilizador(Utilizador utilizador){

		for (Utilizador u: getUtilizadorSet()){
			if (u.equals(utilizador))
				return true;
        }
		return false;
	}

 
}
