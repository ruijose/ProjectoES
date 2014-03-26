package pt.ist.rest.presentationserver;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.*;
import pt.ist.rest.service.*;
import pt.ist.rest.service.dto.*;
import pt.ist.chequerefeicao.*;


public class PresentationServer {

    public final static String DBUSER = "rest";
	public final static String DBPASS = "r3st";
	public final static String DBURL = "//localhost:3306/restdb";
	public final static String DMLPATH = "src/main/dml/rest.dml";
	
	
	
    public static void main(String[] args) {
    	FenixFramework.initialize(new Config() {{
                dbAlias = DBURL;
                dbUsername = DBUSER;
                dbPassword = DBPASS;
    		    domainModelPath = DMLPATH;
    		    rootClass=Rest.class;
    	}});
		
    	
    	
        
    	
    	registaBarrigaCheia();
		imprimeUtilizadores();
		imprimeRestaurantes();
		adicionaBitoque();	
		escreveClassificacao();
	//	gostarPratos1();
	//	gostarPratos2();
		escreveClassificacao2();
		adicionaPratoTabuleiro1();
		adicionaPratoTabuleiro2();
		verificaTabuleiro1();
		verificaTabuleiro2();

   }
	
	@Atomic
	public static void registaBarrigaCheia() {			
		Rest rest = FenixFramework.getRoot();
		Restaurante restaurante = new Restaurante("Barriga Cheia","Porto,Portugal");
		try{
			rest.addRestaurante(restaurante, "pp");
		}catch(RestaurantAlreadyExistsException e){
			System.out.println(e.toString());
		}catch(ManagerNotFoundException e){
			System.out.println(e.toString());
		}catch(BusyManagerException e){
			System.out.println(e.toString());
		}
		
	}
   
    @Atomic
	public static void imprimeUtilizadores(){
		Rest rest = FenixFramework.getRoot();
		rest.imprimeUtilizadores();	
	}
	
	
    public static void imprimeRestaurantes(){

    	ListaRestaurantesService sr = new ListaRestaurantesService();

    	sr.execute();
    	RestaurantPresenter.show(sr.getResult()); 
    }
	
	
    @Atomic
	public static void adicionaBitoque(){
		Rest rest = FenixFramework.getRoot();
		
		try{
			rest.adicionaPratoRestaurante("pp", "Barriga Cheia", 
											new Prato("Bitoque",new Integer(14) ,new Integer(14),rest.incrementaIDPrato()));
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());

		}catch (DishesNumberExceedException e){
			System.out.println(e.toString());
			
		}catch (ManagerNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ManagerHasNoAccessException e){
			System.out.println(e.toString());
		}
	}
	
	@Atomic
	public static void escreveClassificacao(){
		Rest rest = FenixFramework.getRoot();
		final int classificacaoCheia;
		final int classificacaoFeliz;
		
		try{
			classificacaoCheia = rest.calculaClassificacao("Barriga Cheia");
			classificacaoFeliz = rest.calculaClassificacao("Barriga Feliz");
			
			System.out.println("Classificacao do restaurante barrigaCheia:"+classificacaoCheia);
			System.out.println("Classificacao do restaurante barrigaFeliz:"+classificacaoFeliz);
       }catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
	   }
	
	}
	
/*	@Atomic
	public static void gostarPratos(){
		Rest rest = FenixFramework.getRoot();
		
		try{
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Bacalhau com batatas");
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Canja de galinha");
			rest.clienteGostaDePrato("zeze","Barriga Feliz","Bitoque");
			
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ManagerNotFoundException e){
			System.out.println(e.toString());
			
		}catch (DishNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ClientAlreadyLikesDishException e){
			System.out.println(e.toString());
			
		}catch (ClientNotFoundException e){
			System.out.println(e.toString());
			
		}catch (LikesNumberExceedException e){
			System.out.println(e.toString());
		}
	}*/
	
/*	@Atomic
	public static void gostarPratos2(){
		Rest rest = FenixFramework.getRoot();
		try{
			rest.clienteGostaDePrato("mariazinha","Barriga Feliz","Canja de galinha");
		
		}catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
				
		}catch (DishNotFoundException e){
			System.out.println(e.toString());
			
		}catch (ClientAlreadyLikesDishException e){
			System.out.println(e.toString());
			
		}catch (ClientNotFoundException e){
			System.out.println(e.toString());
			
		}catch (LikesNumberExceedException e){
			System.out.println(e.toString());
		}
	}*/
	
	@Atomic
	public static void escreveClassificacao2(){
		Rest rest = FenixFramework.getRoot();
		final int classificacaoCheia;
		final int classificacaoFeliz;
		
		try{
			classificacaoCheia = rest.calculaClassificacao("Barriga Cheia");
			classificacaoFeliz = rest.calculaClassificacao("Barriga Feliz");
			
			System.out.println("Classificacao do restaurante barrigaCheia:"+classificacaoCheia);
			System.out.println("Classificacao do restaurante barrigaFeliz:"+classificacaoFeliz);
       }catch (RestaurantNotFoundException e){
			System.out.println(e.toString());
	   }  
    
	
	}
	
	public static void adicionaPratoTabuleiro1(){
		AddItemService sr = new AddItemService(new ClienteDto("zeze","z3z3"),new PratoSimpleDto("Canja de Galinha"),
				                               new RestauranteSimpleDto("Barriga Feliz") ,3);
		
		sr.execute();
	}
	public static void adicionaPratoTabuleiro2(){
		AddItemService sr = new AddItemService(new ClienteDto("zeze","z3z3"),new PratoSimpleDto("Bacalhau com batatas"),
                                               new RestauranteSimpleDto("Barriga Feliz") ,2);
		sr.execute();
	}

	@Atomic
	public static void verificaTabuleiro1(){
		Rest rest = FenixFramework.getRoot();
		
		rest.procuraClientePorNome("zeze").imprimeTabuleiro();
	}
	
	
	@Atomic
	public static void verificaTabuleiro2(){
		Rest rest = FenixFramework.getRoot();

		rest.procuraClientePorNome("mariazinha").imprimeTabuleiro();
	}
	
	public static void gostarPratos1(){
		
		GostarPratoService sr = new GostarPratoService(new RestauranteSimpleDto("Barriga Feliz"), new PratoSimpleDto("Bacalhau com batatas"), new ClienteDto("zeze","z3z3"));
		GostarPratoService sr1 = new GostarPratoService(new RestauranteSimpleDto("Barriga Feliz"),new PratoSimpleDto("Bitoque"), new ClienteDto("zeze","z3z3"));
		GostarPratoService sr2 = new GostarPratoService(new RestauranteSimpleDto("Barriga Feliz"),new PratoSimpleDto("Canja de Galinha"), new ClienteDto("zeze","z3z3"));

		sr.execute();
		sr1.execute();
		sr2.execute();
	} 
	

	public static void gostarPratos2(){
		GostarPratoService sr = new GostarPratoService(new RestauranteSimpleDto("Barriga Feliz"), new PratoSimpleDto("Canja de Galinha"), new ClienteDto("mariazinha","****"));
		sr.execute();
	} 
	
	
	
	/*
	//Necessario definir + dois servicos e mudar excepcoes, verificar qual e o cliente a testar e os cheques
	public static void pagamentoDeCompra(String nomeCliente, List<String> cheques){
		List<String> checks = new ArrayList<String>();
		ChequeRefeicao chequeRefeicao = new ChequeRefeicao(new ChequeRefeicaoLocal());
		int amount;
		
		try {
		    valorCheques = chequeRefeicao.cashChecks(nomeCliente, cheques);
		  //assert() amount received is equal to strings cheques
		   	ClienteDto cliente = newClienteDto(nomeCliente,null);	//necessario password?
		    ActualizarSaldoService sr = new ActualizaSaldoService(cliente,valorCheques); 
		    sr.execute();
		    RegistaPagamentoService sr1 = new RegistaPagamentoService(cliente);
		    sr1.execute();
		 
		} catch (InvalidCheckException ice) {
		    System.out.println("Could not make valid registry of checks! " + ice);
		} catch (CheckAlreadyUsedException cae) {
		    System.out.println("Could not make valid registry of checks!" + cae);
		}
		
	}*/
	
}



    			
 

