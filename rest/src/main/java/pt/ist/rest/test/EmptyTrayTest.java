package pt.ist.rest.test;

import org.junit.Test;
import pt.ist.rest.service.dto.*;
import pt.ist.rest.exception.*;
public class EmptyTrayTest {

	
	@Test
	public void testClienteNaoExiste(){
		//Username do cliente que nao existe na base de dados
		 ClienteDto clienteDto = new ClienteDto("JorgeJesus",null);
		
		try{
			//Chama o metodo que limpa o tabuleiro deste cliente
			//pt.ist.rest.service.EmptyTrayService(clienteDto);
			fail("Failure: O tabuleiro de um cliente que nao existe foi eliminado");
		}catch(ClientNotFoundException e){
			//success
		}catch(EmptyShoppingTrayException e){
			fail("Failure: O tabuleiro de um cliente que nao existe foi verificado")
		}
		 
	}
	@Test
	public void testTabuleiroJaVazio(){
		//Username do cliente que existe na base de dados
		ClienteDto clienteDto = new ClienteDto("zeze","z3z3");
		
		try {
			
			
		}
	}
	
	// se o cliente nao existe
	// com tabuleiro ja vazio
	// com tauleiro nao pago
	// com tabuleiro pago
	
	
}

