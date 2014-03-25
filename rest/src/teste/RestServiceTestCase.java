package pt.ist.rest.service;

import java.util.Set;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.pstm.Transaction;
import pt.ist.rest.domain.*;
import junit.framework.TestCase;

import jvstm.Atomic;


public abstract class RestServiceTestCase extends TestCase {
	 static {
	    if(FenixFramework.getConfig()==null) {
	    		FenixFramework.initialize(new Config() {{
			    domainModelPath="src/main/dml/rest.dml";
			    dbAlias = "//localhost:3306/restdb";
			    dbUsername = "rest";
			    dbPassword = "r3st";
			    rootClass=Rest.class;
	    		}});
	    	}
	    }

	 	protected RestServiceTestCase(String msg) {
	    	super(msg);
	    }
	    
	    protected RestServiceTestCase() {
	    	super();
	    }
	    
	    protected void setUp() {
		cleanRest();
	    }	

	    protected void tearDown() {
		cleanRest();
	    }


	    @Atomic
	    protected void cleanRest() {
		Rest rest = FenixFramework.getRoot();
		Set<Restaurante> Restaurantes = rest.getRestauranteSet();
		Restaurantes.clear();
	    }
	    
	    private Restaurante getRestaurante(String nomeRestaurante) {
		Rest rest = FenixFramework.getRoot();
		return rest.procuraRestaurantePorNome(nomeRestaurante);
	    }

	    @Atomic
	    protected boolean verificaRestaurante(String nomeRestaurante) {
		return getRestaurante(nomeRestaurante) != null;
	    }

	    @Atomic
	    protected boolean verificaPrato(String nomeRestaurante, String nomePrato) {
		Restaurante restaurante = getRestaurante(nomeRestaurante);
		return (restaurante != null && restaurante.hasPrato(restaurante.procuraPrato(nomePrato)));
	    }

	    
	    @Atomic
	    protected void adicionaRestaurante(String nomeRestaurante, String moradaRestaurante) {
		Rest rest = FenixFramework.getRoot();
		rest.addRestaurante(new Restaurante(nomeRestaurante, moradaRestaurante));
	    }
	    
	    @Atomic
	    protected void adicionaPrato(String nomeRestaurante, String nomePrato, Integer preco, Integer calorias, Integer IDPrato) {
		Restaurante restaurante = getRestaurante(nomeRestaurante);
		restaurante.adicionaPrato(new Prato(nomePrato, preco, calorias, IDPrato));
	    }
	    
	    @Atomic
	    protected int getNumeroPratos(String nomeRestaurante) {
		return getRestaurante(nomeRestaurante).getPratoCount();
	    }
	    
}
