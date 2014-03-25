package pt.ist.rest.service;

import  pt.ist.rest.service.AddItemService;
import  pt.ist.rest.service.dto.*;
import  pt.ist.rest.exception.*;

public class AdicionaItemServiceTest extends RestServiceTestCase{
	
	
	private static String EXISTING_USER_NAME = "Bart";
	private static String EXISTING_CLIENT_ADDRESS = "DressRosa";
	private static String EXISTING_CLIENT_NAME = "Bartholomeu Supernova";
	private static String EXISTING_PRATO = "Chicken Tika";
	private static String EXISTING_RESTAURANT_NAME = "Konichi Place";
	private static String EXISTING_MAIL = "barrister@ko.com";
	private static String EXISTING_CLIENT_PASS = "b3rt";
    private static String NON_EXISTING_USER_NAME = "Capitain Kirk";
    private static String NON_EXISTING_RESTAURANT_NAME = "Darth Hood";
	private static String NON_EXISTING_PRATO = "Chicken Tika Masala";
	
      
	public AdicionaItemServiceTest(String msg) {
		super(msg);
	    }
		
	    public AdicionaItemServiceTest() {
		super();
	    }
	   
	    @Override
	    public void setUp() {
		super.setUp();
		adicionaCliente(EXISTING_CLIENT_NAME,EXISTING_CLIENT_ADDRESS,EXISTING_USER_NAME,EXISTING_MAIL,EXISTING_CLIENT_PASS);
		adicionaRestaurante(EXISTING_RESTAURANT_NAME, EXISTING_CLIENT_ADDRESS);
		addPrato(EXISTING_RESTAURANT_NAME, EXISTING_PRATO,34, 45,3);
		
		
	    }
	   
	public void testCreateNewInexistentItem() {
		// Arrange
	PratoSimpleDto
	dto = new PratoSimpleDto(EXISTING_PRATO);
	RestauranteSimpleDto restauranteDto = new RestauranteSimpleDto(EXISTING_RESTAURANT_NAME);
	ClienteDto clienteDto = new ClienteDto(EXISTING_USER_NAME,EXISTING_CLIENT_PASS,EXISTING_CLIENT_NAME,EXISTING_CLIENT_ADDRESS,EXISTING_MAIL);
	AddItemService addService = new AddItemService(clienteDto, dto,restauranteDto,4);
	int nItemsBefore = getNumberOfItems(EXISTING_USER_NAME);


	// Act
	try {
	    addService.execute();
	} catch(ClientNotFoundException e) {
	    fail("Could not add item: " + e.getMessage());
	} catch (DishNotFoundException pdne) {
	    fail("Could not add item: " + pdne.getMessage());
	} catch (RestaurantNotFoundException pdne) {
	    fail("Could not add item: " + pdne.getMessage());
	}

	//Assert
		assertTrue("New item was not added to client compra", verificaItem(EXISTING_CLIENT_NAME, EXISTING_PRATO, EXISTING_RESTAURANT_NAME));
		assertEquals("The number of Items should be incresed by one.", nItemsBefore + 1, getNumberOfItems(EXISTING_USER_NAME));

    }
}