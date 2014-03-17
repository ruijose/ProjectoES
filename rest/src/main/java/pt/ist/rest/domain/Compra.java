package pt.ist.rest.domain;

public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    
    public void adicionaItem(Item item){
        this.setCusto(somaCusto(item));
    	super.addItem(item);
    }

    public void removeItem(Item item){
    	super.removeItem(item);	
    }

    public void somaCusto(Item item){
        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
        final int QUANTIDADE = item.getQuantidade();
        return CUSTO + (PRECO * QUANTIDADE);
    }



    

}

