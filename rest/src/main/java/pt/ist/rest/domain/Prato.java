package pt.ist.rest.domain;

import java.util.Set;

public class Prato extends Prato_Base {
    
    public final static String CARNE = "carne";
    public final static String PEIXE = "peixe";
    public final static String CARNE_PEIXE = "carne+peixe";
    public final static String VEGETARIANO = "vegetal";

	
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
    /**
     *	Descobre o tipo do prato, verificando todos os alimentos que contem .
     * 	Um prato ou e de peixe ou de carne quando nao tem so vegetais,
     *  supomos que nao pode ter ambos os alimentos.
     *
     *	@return enum Tipo com tipo de prato: CARNE,PEIXE,VEGETARIANO, CARNE_E_PEIXE
     */
    public String getTipoPrato(){
        String tipo = VEGETARIANO;

    	for (Alimento a: getAlimentoSet()){
    		if (isCarneOrPeixe(a)) {
                if (a.getTipo().equals(tipo))
                    tipo = a.getTipo();
                else
                    return CARNE_PEIXE;
                }
    	}          
    	return tipo;
    }
    
    private final boolean isCarneOrPeixe(Alimento a){
    	return a.getTipo().equals(CARNE) || a.getTipo().equals(PEIXE);
    }
    
    public boolean isTipo(String tipo){
    	String tipoPrato = getTipoPrato();
        if (tipoPrato.equals(CARNE_PEIXE) && !tipo.equals(VEGETARIANO))
            return true;
        return tipoPrato.equals(tipo);
    }
    /*
     * Metodos auxiliares para manipular os Alimentos dos pratos, 
     * 
     */
    @Override
    public void addAlimento(Alimento alimento){
    	if (!this.hasAlimento(alimento))
    		super.addAlimento(alimento);
    	
    }
    /** 
     * Adiciona um Set de alimentos ao prato.
     * O metodo addAlimento(Alimento) verifica se o alimento ja existe
     * 
     * @param alimentos 	Set de alimentos a adicionar ao prato
     * 
     */
    public void addAlimentos(Set<Alimento> alimentos){
    	for (Alimento a: alimentos){
    		this.addAlimento(a);
    	}
    }
    
    
    public String toString(){
    	return getNome() + "|" + getCalorias() + "|" + getPreco() + "|" + Integer.toString(calculaClassificacao());
    }
    
}