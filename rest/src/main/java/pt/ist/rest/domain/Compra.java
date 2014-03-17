package pt.ist.rest.domain;

public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    
    public void adicionaItem(Prato prato, int quantidadePrato){
	//cria um item novo, se nao existir, se existir actualiza a quantidade e destrói se for menor ou igual a 0
		final Item item = getItemDoPrato();
		if (item == null)
			super.addItem(new Item(prato, quantidadePrato));
		else
			item.mudaQuantidade(quantidadePrato);
		
		if (item.getQuantidade() =< 0){
			super.removeItem(item);
			final int custoCompraSemItem = item.getQuantidade - quantidadePrato();	//custo deste prato na compra
			this.mudaCusto(item,(-custoCompraSemItem));
		}
		else this.mudaCusto(item, quantidadePrato);
    }

    public void removeItem(Item item){
    	super.removeItem(item);	
    }

    public void mudaCusto(Item item,int quantidadePrato){
        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
        this.setCusto(CUSTO + (PRECO * quantidadePrato));
    }
	public boolean getItem(Prato prato){
		for (Item i: getItemSet()){
			if (i.isItemde(prato))
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

