package pt.ist.rest.domain;

import java.util.List;

import pt.ist.rest.exception.EmptyShoppingTrayException;
import pt.ist.registofatura.ws.Fatura;
import pt.ist.registofatura.ws.ItemFatura;



public class Compra extends Compra_Base {
    private Fatura fatura = new Fatura(); 
    
    public  Compra() {
        super();
        setCusto(0);
        setConfirma(new Integer(0));
    }
   
    @Override
    public void setCliente(Cliente c){
    	c.addCompra(this);
    	 
 }
    
    public Fatura getFatura(){
    	return fatura;
    }
    
    public void setFatura(Fatura fatu){
    	fatura=fatu;
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
    	final ItemFatura itemFatura = new ItemFatura();
		final Item item = getItemPorPrato(prato);
		itemFatura.setDescricao("ola");
		itemFatura.setQuantidade((int)quantidadePrato);
		itemFatura.setPreco((int)prato.getPreco());
		if (item == null){
			if (quantidadePrato > 0){
				super.addItem(new Item(prato,quantidadePrato));
				fatura.getItens().add(itemFatura);
				fatura.setTotal(fatura.getTotal()+prato.getPreco());
			return;
			}
		}
		item.mudaQuantidade(quantidadePrato);
		
		if (item.getQuantidade() <= 0){
			final int custoCompraSemItem = item.getQuantidade() - quantidadePrato;
			this.somaCusto(item,(-custoCompraSemItem));
			removeItemFatura(itemFatura, item);
			
		}
		else this.somaCusto(item, quantidadePrato);
    }
    
    public void removeItemFatura(ItemFatura itemFatura, Item item){
    	super.removeItem(item);
		fatura.getItens().remove(itemFatura);
		fatura.setTotal(item.getPrato().getPreco());
    	
    }
    
    @Override
    public void removeItem(Item item){
    	super.removeItem(item);	
    }

    public void somaCusto(Item item, int quantidadePrato){

        final int CUSTO = this.getCusto();
        final int PRECO = item.getPrato().getPreco();
		this.setCusto(CUSTO + (PRECO * quantidadePrato));
		fatura.setTotal(this.getCusto());
		System.out.print("custo: "+ getCusto());
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
    @Override
	public List<Item> getItem() throws EmptyShoppingTrayException{
		List<Item> list = super.getItem();
    	if (list.isEmpty())
    		throw new EmptyShoppingTrayException();
    	return list;
    }

}

