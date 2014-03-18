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
    
    public void adicionaItemACompra(Prato itemComprado,int quantidadePrato){

        final Compra compra = getCompraAberta();
        compra.adicionaItem(itemComprado,quantidadePrato);
    }

    @Override   
    public void setSaldo(Integer saldo){
        if(saldo < 0)
            System.out.println("EXCEPCAO");
        super.setSaldo(saldo);
    }
        
    @Override
    public void addCompra(Compra compraParaAdicionar) { //ADICIONA AO TABULEIRO

      super.addCompra(compraParaAdicionar);	
    }

    public void confirmaCompra(){

<<<<<<< HEAD

		 if (!hasComprasAberta())
||||||| merged common ancestors
<<<<<<< HEAD
        final int CUSTO = compra.getCusto();
||||||| merged common ancestors
        final int CUSTO = compra.somaCusto();
=======
		 if (!hasComprasAberta())
=======
		if (!hasComprasAberta())
>>>>>>> ed4a50e111ca9a4a56e75186d5d5cd795863d77e
            System.out.println("EXCEPCAO O TABULEIRO DE COMPRAS ESTA VAZIO");     
		
		final Compra compra = this.getCompraAberta();
		
		final boolean compraTemItems = (compra.getItemCount() > 0);
		if (!compraTemItems)
			 System.out.println("EXCEPCAO O TABULEIRO DE COMPRAS ESTA VAZIO");     
			 
        final int CUSTO = compra.getCusto();
<<<<<<< HEAD

||||||| merged common ancestors
>>>>>>> d15a70b4d86b2d3ad6c2015b2b1323567a7f8d4f
=======
>>>>>>> ed4a50e111ca9a4a56e75186d5d5cd795863d77e
        final int SALDO = getSaldo();
        if (SALDO > CUSTO){
            this.setSaldo(SALDO - CUSTO);
            compra.setConfirma(new Integer(1));
        }
        else System.out.println("EXCEPCAO SALDO INSUFICIENTE");

    }
    
    public boolean hasComprasAberta(){

        for (Compra c:getCompraSet())
            if (c.getConfirma() == 0)
                return true;

        return false;
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
