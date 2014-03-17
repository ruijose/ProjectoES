package pt.ist.rest.domain;

import pt.ist.rest.exception.*;

public class Cliente extends Cliente_Base {
    
	private final int MAX_GOSTOS = 15;  
    
    
    public  Cliente() {
        super();

    }
    
    public Cliente(String nome, String morada, String user, String mail, String pass){
    	
    	super();
    	init(user,nome,pass,mail,morada);
    }
    
    
    protected void init(String user, String nome, String pass, String mail, String morada){
    	super.init(user, pass);
    	setNome(nome);
    	setEmail(mail);
    	setMorada(morada);
    		
    }

    public Compra getCompraAberta(){
        for (Compra c:getCompraSet())
            if (c.getConfirma() == 0)
                return c;
        this.addCompra(new Compra());
        assert (getCompraAberta() != null) : "A compra nao existe";
        return getCompraAberta(); 
    }
    
    public void adicionaItemACompra(Item itemComprado){

        final Compra compra = getCompraAberta();
        compra.adicionaItem(itemComprado);
    }
        
    @Override
    public void addCompra(Compra compraParaAdicionar){

    	   super.addCompra(compraParaAdicionar);	
    }
    
    public void confirmaCompra(Compra compra){
    	
    	compra.setConfirma(new Integer(1));   	
    }
    
    
    @Override
    public void removeCompra(Compra compra){
    	
    	super.removeCompra(compra);
    		
    }
    
    
    public void addGosto(Prato p) throws LikesNumberExceedException, ClientAlreadyLikesDishException{
    	if(getPratoCount() > MAX_GOSTOS)
    		throw new LikesNumberExceedException(getPratoCount());
			
    	else if (hasPrato(p))
			throw new ClientAlreadyLikesDishException(super.getUsername(),p.getNome());
			
    	else 
			super.addPrato(p);		
    }

    
    public void removeGosto(Prato pratoRemove){

    	for(Prato p: getPratoSet()){
        	if(p.equals(pratoRemove))
    			super.removePrato(p);   

    	}
    }
	
	
    public void substituiGosto(Prato pratoIn,Prato pratoOut){
    	
    	removeGosto(pratoOut);
    	addGosto(pratoIn);
    }
	
	public String toString(){
		return "Cliente | "+ this.getNome();
	}
    
  }
