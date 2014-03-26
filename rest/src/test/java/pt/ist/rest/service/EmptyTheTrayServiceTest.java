package pt.ist.rest.service;

//import pt.ist.service .EmptyTheTrayService;
import pt.ist.rest.exception.*;
import pt.ist.rest.service.dto.*;

public class EmptyTheTrayServiceTest extends RestServiceTestCase{
	
	private final static String EXISTING_USER_NAME = "Bart";
	private final static String EXISTING_CLIENT_ADDRESS = "DressRosa";
	private final static String EXISTING_CLIENT_NAME = "Bartholomeu Supernova";
	private final static String EXISTING_PRATO = "Chicken Tika";
	private final static String EXISTING_RESTAURANT_NAME = "Konichi Place";
	private final static String EXISTING_MAIL = "barrister@ko.com";
	private final static String EXISTING_CLIENT_PASS = "b3rt";
	private final static String NON_EXISTING_USER_NAME = "Jorge Jesus";

	
	//testes 
	//cliente nao existe
	//o utizador e' um gestor
	//o tabuleiro está vazio
	//o tabuleiro não está confirmado
	//o tabuleiro tem items e está confirmado
	
	@Override
	protected void setUp(){
		super.setUp();	//cleans the db
		adicionaRestaurante(EXISTING_RESTAURANT_NAME, EXISTING_CLIENT_ADDRESS);
		adicionaCliente(EXISTING_CLIENT_NAME,
						EXISTING_CLIENT_ADDRESS,
						EXISTING_USER_NAME,
						EXISTING_MAIL,
						EXISTING_CLIENT_PASS);
		addPrato(EXISTING_RESTAURANT_NAME, EXISTING_PRATO,34, 45,3);
		addItem(EXISTING_RESTAURANT_NAME,
				EXISTING_USER_NAME,
				EXISTING_PRATO,
				2); 

		PratoSimpleDto pratoDto = new PratoSimpleDto(EXISTING_PRATO);
		RestauranteSimpleDto restauranteDto = new RestauranteSimpleDto(EXISTING_RESTAURANT_NAME);
	}
	
	public void testClienteExists(){
		
		ClienteDto clienteDto = new ClienteDto(NON_EXISTING_USER_NAME,null);
		
		try{
			//new EmptyTheTrayService(clienteDto).execute();
			fail("Client Not Found Exception not thrown");
		}catch (ClientNotFoundException e){ // cliente nao existe exception
			System.out.println("Success");
		}
	
	}
	public void testTabuleiroVazio(){
		
		ClienteDto clienteDto = new ClienteDto(EXISTING_USER_NAME,null);
		try{
			//new EmptyTheTrayService(clienteDto).execute();
			
		}catch(ClientNotFoundException e){
			fail("The client exists, but was not found");
		}
		assertFalse("The tray should not have a negative amount of items",
								getNumberOfItems(EXISTING_USER_NAME)<0);
		assertTrue("The tray is not empty",getNumberOfItems(EXISTING_USER_NAME)==0);
		
		
	}

} 