package pt.ist.rest.domain;

import pt.ist.rest.exception.*;

public class Restaurante extends Restaurante_Base {
	
	private final int MAX_PRATOS = 15;  


	public  Restaurante(String nome, String morada) {
		super();
		setNome(nome);
		setMorada(morada);

	}

	public Gestor procuraGestorPorNome(String user){
		for(Gestor g : getGestorSet()){
			if(g.getUsername().equals(user))
				return g;	
		}
		return null;
	}

	public void addGestor(Gestor g) throws BusyManagerException{
		
		if(g.hasRestaurante()){
			throw new BusyManagerException(g.getUsername());
		}
		else super.addGestor(g);
	}
	

    
    public void removeGestor(String username) throws RestWithoutManagerException{
    	Gestor gestor = procuraGestorPorNome(username);
    	if(getGestorCount() < 2)
    		throw new RestWithoutManagerException(username);	
    	else
    		super.removeGestor(gestor);

    }
    
    public Prato procuraPrato(String nome){
    	for(Prato p: getPratoSet()){
    		if(p.getNome().equals(nome))
    			return p;
    	}
    	return null;
    }
    
    public void adicionaPrato(Prato p) throws DishesNumberExceedException{
		
    	if(getPratoCount() >= MAX_PRATOS)
    		throw new DishesNumberExceedException(getPratoCount());
    	else super.addPrato(p);	
    	
   }
    public int calculaClassificacao(){
	
		int classificacao = 0;
    	int numPratosClassificados = 0;
	
		for(Prato p: getPratoSet()){
    		if(p.calculaClassificacao()>=1)
    		   numPratosClassificados++;	
    	
    		classificacao += p.calculaClassificacao(); 
   		}
		
		final int numPratos = getPratoCount();
    	final float classificacaoMedia = (float)classificacao / (float)numPratos;
    	
		final boolean restauranteTemClassificacao = numPratosClassificados >=3;
		
    	if(restauranteTemClassificacao)
    	   return (int)Math.round(classificacaoMedia);
    	else
    		System.out.println("Restaurante sem classificacao");
    	
    	return 0;
	}

    public boolean hasGestor(String nomeGestor){
    	return procuraGestorPorNome(nomeGestor)!=null;
    }
    
    public String getPratoDescricao(){

    	String descricoes = "";

    	for(Prato p: getPratoSet()){
    		descricoes += p.getNome() + "|";
    	}
    	return descricoes;
    }

    public String toString(){
    	return getNome() + "|" + getMorada() + "|" + "pratos:" + getPratoDescricao(); 
    }

    
	
	public boolean equals(Restaurante r){
		return this.getNome().equals(r.getNome());
	}
	
	public String toString2(){
		
		return getNome() + "|" + getMorada() + "|" + Integer.toString(calculaClassificacao());
	}
	
}

