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
    
<<<<<<< HEAD
    public String toString(){
    	return getNome() + "|" + getCalorias() + "|" + getPreco() + "|" + Integer.toString(calculaClassificacao());
    }
=======
    
   
>>>>>>> 9dad73d86a8ff46ed0f3ab0ae17ed545f72d6dfe
    
}