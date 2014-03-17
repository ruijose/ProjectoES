package pt.ist.rest.domain;

public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    
    public void adicionaItem(Prato novoItem){
	//cria um item novo, se nao existir, se existir actualiza a quantidade e destrói se for menor ou igual a 0
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

<<<<<<< HEAD
    public int somaCusto(Item item){
||||||| merged common ancestors
    public void somaCusto(Item item){
=======
    public void mudaCusto(Item item){
>>>>>>> d15a70b4d86b2d3ad6c2015b2b1323567a7f8d4f
        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
        final int QUANTIDADE = item.getQuantidade();
        this.setCusto(CUSTO + (PRECO * QUANTIDADE));
    }



    

}

