package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.*;


public class AddItemService extends RestService{
	
	private ClienteDto cliDto;
	private PratoDto praDto;
	private RestauranteSimpleDto restauranteDto; 
	private ItemDto itemDto;

	public AddItemService(ClienteDto cliDto, PratoDto praDto,RestauranteSimpleDto restauranteDto ){
		this.cliDto = cliDto;
		this.praDto = praDto;
		this.restauranteDto = restauranteDto;
	}
	
	
   
	public final void dispatch(){
		Rest rest = FenixFramework.getRoot();
		
		final Cliente cliente = rest.procuraClientePorNome(cliDto.getUser());
		final Prato prato = rest.procuraPratoEmRestaurante(restauranteDto.getNome(), praDto.getNomeP());
		
		
		if(cliente == null){
			System.out.println("cliente inexistente");
		}
			cliente.adicionaItemACompra(prato, praDto.getQuantidade());
			
		}
		
	}
	
