package pt.ist.rest.domain;


public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    @Override
    public void setCliente(Cliente c){
    	c.addCompra(this);
    }
    /**
      *	Adiciona um prato ao carrinho de compras.
      *	Se o prato ja' existir, muda a quantidade desse prato.
      *	Se a quantidade resultante for negativa, remove o custo do prato na encomenda
      * e remove-o.
      *
      *	@param prato 	que se quer adicionar 'a compra
      *	@param quantidadePrato		valor da quantidade relativo ao prato
      *
      */
    public void adicionaItem(Prato prato, Integer quantidadePrato){
    	
		final Item item = getItemPorPrato(prato);
		if (item == null){
			if (quantidadePrato > 0)
			super.addItem(new Item(prato,quantidadePrato));
			return;
		}
		
		item.mudaQuantidade(quantidadePrato);
		
		if (item.getQuantidade() <= 0){
			final int custoCompraSemItem = item.getQuantidade() - quantidadePrato;
			this.somaCusto(item,(-custoCompraSemItem));
			super.removeItem(item);
		}
		else this.somaCusto(item, quantidadePrato);
		
    }
    
    @Override
    public void removeItem(Item item){
    	super.removeItem(item);	
    }

    public void somaCusto(Item item, int quantidadePrato){

        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
		this.setCusto(CUSTO + (PRECO * quantidadePrato));


    }

    
	public Item getItemPorPrato(Prato prato){
		for (Item i: getItemSet()){
			if (i.isItemDe(prato))
				return i;
		}
		return null;
	}
	
	public boolean compraTemPrato(Prato prato){
		for (Item i: getItemSet()){
			if (i.isItemDe(prato))
				return true;
		}
		return false;
	}
    

}

