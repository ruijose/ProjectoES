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

<<<<<<< HEAD
<<<<<<< HEAD
    public int somaCusto(Item item){
||||||| merged common ancestors
    public void somaCusto(Item item){
=======
    public void mudaCusto(Item item){
>>>>>>> d15a70b4d86b2d3ad6c2015b2b1323567a7f8d4f
||||||| merged common ancestors
    public void mudaCusto(Item item){
=======
    public void mudaCusto(Item item,int quantidadePrato){
>>>>>>> e0ad3c5445b0cdffea15059ea1714b5374c53cdf
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

