package pt.ist.rest.domain;

public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    
    public void adicionaItem(Prato novoItem){
	//cria um item novo, se nao existir, se existir actualiza a quantidade e destr�i se for menor ou igual a 0
/*
		if (this.hasItem(item))
			if (item.get)
    	else
			this.setCusto(mudaCusto(item));
			*/super.addItem(item);
    }

    public void removeItem(Item item){
    	super.removeItem(item);	
    }

    public void mudaCusto(Item item){
        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
        final int QUANTIDADE = item.getQuantidade();
        this.setCusto(CUSTO + (PRECO * QUANTIDADE));
    }



    

}

