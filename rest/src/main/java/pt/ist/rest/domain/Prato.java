package pt.ist.rest.domain;

public class Prato extends Prato_Base {
    

	
    public  Prato(String nome, Integer preco, Integer calorias,Integer IDPrato) {
        super();
        setNome(nome);
        setPreco(preco);
        setCalorias(calorias);
		setIDPrato(IDPrato);
        
    }    
    @Override
    public void setRestaurante(Restaurante r){
    	r.addPrato(this);
    }
    public int calculaClassificacao(){
    	return  getClienteCount(); 
   }
    /**
     * 	Procura uma cadeira de caracteres especifica no nome do Prato.
     * 	
     * @param substring	cadeia de caracteres a procurar
     */
    public boolean containsSubstring(String substring){
    	return this.getNome().toLowerCase().contains(substring.toLowerCase());
    }
    
    public String toString(){
    	return getNome() + "|" + getCalorias() + "|" + getPreco() + "|" + Integer.toString(calculaClassificacao());
    }
    
}