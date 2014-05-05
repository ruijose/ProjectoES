package pt.ist.rest.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    

   
    public Restaurante procuraRestaurantePorNome(String nome)throws RestaurantNotFoundException {
    	for(Restaurante r : getRestauranteSet()){
    	    if(r.getNome().equals(nome)) 
				return r; 
    	    	
        }
    	throw new RestaurantNotFoundException(nome);
    	
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
				
		final Cliente cliente = procuraClientePorNome(username);
		if (!hasRestaurante(nomeRestaurante))
			throw new RestaurantNotFoundException(nomeRestaurante);
		final Prato prato = procuraPratoEmRestaurante(nomeRestaurante,nomePrato);

		cliente.addGosto(prato);
	}
	/**
	 * 	Adiciona um prato a um restaurante, para um gestor ser valido tem que
	 *  existir e gerir o restaurante.
	 * 
	 * @param usernameGestor
	 * @param nomeRestaurante
	 * @param novoPrato
	 * @throws RestaurantNotFoundException	
	 * @throws ManagerNotFoundException		Se o gestor nao existir na base de dados
	 * @throws ManagerHasNoAccessException	O gestor existe, mas nao gere o restaurante dado
	 * @throws DishesNumberExceedException	O restaurante ultrapassou a sua capacidade de pratos
	 */
	public void adicionaPratoRestaurante(String usernameGestor, String nomeRestaurante, Prato novoPrato)
		throws RestaurantNotFoundException, ManagerNotFoundException, ManagerHasNoAccessException, DishesNumberExceedException{
		
		final Restaurante restaurante = procuraRestaurantePorNome(nomeRestaurante);
		final Gestor gestor = procuraGestorPorNome(usernameGestor);
		final boolean GestorGereRestaurante = gestor.getRestaurante().equals(restaurante);
		if (!GestorGereRestaurante)
			throw new ManagerHasNoAccessException(gestor.getUsername());
	
		restaurante.adicionaPrato(novoPrato);

	}
	
	
    
    public int calculaClassificacao(String nomeRestaurante) throws RestaurantNotFoundException{
    	
		Restaurante restaurante = procuraRestaurantePorNome(nomeRestaurante);
		if (restaurante == null)
			throw new RestaurantNotFoundException(nomeRestaurante);
		else 
			return restaurante.calculaClassificacao();
    }
    
    public Cliente procuraClientePorNome(String nomeCliente)throws ClientNotFoundException{
    	for(Cliente c: getClienteSet()){
    		if(c.getUsername().equals(nomeCliente)){
    		   return c;
    		}
		}
    	throw new ClientNotFoundException(nomeCliente);
    }
    
    
    public Prato procuraPratoSubstringEmRestaurante(String nomeRestaurante,String substringPrato)
    		throws RestaurantNotFoundException, DishNotFoundException{
    	final Restaurante r = procuraRestaurantePorNome(nomeRestaurante);
    	for(Prato p: r.getPratoSet()){
    		if(p.containsSubstring(substringPrato)){
    			return p;
    		}
    	}
    	throw new DishNotFoundException(substringPrato, nomeRestaurante);
    }
    
    /**
     * Procura todos os pratos que sejam do tipo pretendido.
     * 
     * @param tipoPrato  a string tipo que se quer verificar
     * 
     * 
     * @see pt.ist.rest.domain.Prato
     * 
     * @throws RestauranteNotFoundException  nao foi encontrado nenhum restaurante com o nome dado
     */
    
    public List<Prato> procuraPratosTipo(String tipoPrato) throws DishesNotFoundException{
    	
    	final List<Prato> pratosTipo = new ArrayList<Prato>();
    	for (Restaurante r: getRestauranteSet()){
    		for (Prato p: r.getPratoSet()){
    			if (p.isTipo(tipoPrato))
    				pratosTipo.add(p);
    		}
    	}
    	if (pratosTipo.isEmpty())
    		throw new DishesNotFoundException(tipoPrato);
    	return Collections.unmodifiableList(pratosTipo);
    }
    
    /**	Procura em todos os restaurantes pelos pratos com a substring dada.
     * 
     * @param substringPrato substring que se quer comparar
     * @return lista de pratos que contem a substring
     */
    public List<Prato> procuraPratoSubstring(String substringPrato) throws DishesNotFoundException{
    	final List<Prato> pratos = new ArrayList<Prato>();
    	for (Restaurante r : getRestauranteSet()){
    		for (Prato p : r.getPratoSet()){
    			if (p.containsSubstring(substringPrato))
    				pratos.add(p);
    		}
    	}
    	if (pratos.isEmpty())
    		throw new DishesNotFoundException(substringPrato);
    	return Collections.unmodifiableList(pratos);
    }
    
    public Prato procuraPratoEmRestaurante(String nomeRestaurante,String nome)
    				throws DishNotFoundException, RestaurantNotFoundException{
    	
    	final Restaurante r = procuraRestaurantePorNome(nomeRestaurante);
    	for(Prato p: r.getPratoSet()){
    		if(p.getNome().equals(nome)){
    			return p;
    		}
    	}
    	throw new DishNotFoundException(nome, nomeRestaurante);
    }
	public Gestor procuraGestorPorNome(String usernameGestor) throws ManagerNotFoundException{
		for (Restaurante r: getRestauranteSet()){
			for (Gestor g: r.getGestorSet()){
				if (g.getUsername().equals(usernameGestor))
					return g;
			}
		}
		throw new ManagerNotFoundException(usernameGestor);
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
    	for(Restaurante r : getRestauranteSet()){
    	    if(r.getNome().equals(nomeRestaurante)) 
				return true; 
        }
    	return false;
    }
    
    @Override
    public boolean hasCliente(Cliente cliente){
    	for (Cliente c: getClienteSet()){
    		if (c.equals(cliente))
    			return true;
    	}
    	return false;

    }
    
	public boolean hasUtilizador(Utilizador utilizador){

		for (Cliente c: getClienteSet()){
			if (c.equals(utilizador))
				return true;
        }
		for (Restaurante r: getRestauranteSet()){
			for (Gestor g: r.getGestorSet())
			{
				if(g.equals(utilizador))
					return true;
			}
		}
		return false;
	}

 
}
