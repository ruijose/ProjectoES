package pt.ist.rest.domain;

public class Compra extends Compra_Base {
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
    
    public void adicionaItem(Prato prato, Integer quantidadePrato){
	//cria um item novo, se nao existir, se existir actualiza a quantidade e destrói se for menor ou igual a 0
		final Item item = getItemPorPrato(prato);
		if (item == null){
			//item = new Item(prato,quantidadePrato);
			super.addItem(new Item(prato,quantidadePrato));
		}
		else
			item.mudaQuantidade(quantidadePrato);
		
		
		if (item.getQuantidade() <= 0){
			super.removeItem(item);
			final int custoCompraSemItem = item.getQuantidade() - quantidadePrato;	//custo deste prato na compra
			this.mudaCusto(item,(-custoCompraSemItem));
		}
		else this.mudaCusto(item, quantidadePrato);
    }

    public void removeItem(Item item){
    	super.removeItem(item);	
    }

<<<<<<< HEAD


    

||||||| merged common ancestors
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
=======
>>>>>>> ed4a50e111ca9a4a56e75186d5d5cd795863d77e
    public void mudaCusto(Item item,int quantidadePrato){

        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
        this.setCusto(CUSTO + (PRECO * quantidadePrato));
    }
	public Item getItemPorPrato(Prato prato){
		for (Item i: getItemSet()){
			if (i.isItemDe(prato))
				return i;
		}
		return false;
	}
	
	public boolean compraTemPrato(Prato prato){
		for (Item i: getItemSet()){
			if (i.isItemDe(prato))
				return true;
		}
		return false;
	}
    

}

