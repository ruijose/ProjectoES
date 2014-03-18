package pt.ist.rest.domain;

public class Prato extends Prato_Base {
    

	
    public  Prato(String nome, Integer preco, Integer calorias,Integer IDPrato) {
        super();
        setNome(nome);
        setPreco(preco);
        setCalorias(calorias);
		setIDPrato(IDPrato);
        
    }    
    
    public int calculaClassificacao(){
    	return  getClienteCount(); 
   }
   
    
}