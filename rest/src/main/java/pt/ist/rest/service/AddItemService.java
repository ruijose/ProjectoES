package pt.ist.rest.service;
import pt.ist.rest.exception.*;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.service.dto.*;


public class AddItemService extends RestService{
	
	private ClienteDto cliDto;
	private PratoSimpleDto praDto;
	private RestauranteSimpleDto restauranteDto; 
	private int quantidade;

	public AddItemService(ClienteDto cliDto, PratoSimpleDto praDto,RestauranteSimpleDto restauranteDto,int quantidade){
		this.cliDto = cliDto;
		this.praDto = praDto;
		this.restauranteDto = restauranteDto;
		this.quantidade = quantidade;
	}
	
	
   
	public final void dispatch() throws ClientNotFoundException{
		Rest rest = FenixFramework.getRoot();
		
		final Cliente cliente = rest.procuraClientePorNome(cliDto.getUser());
		final Prato prato = rest.procuraPratoEmRestaurante(restauranteDto.getNome(), praDto.getNome());
		
		
		if(cliente == null)
			throw new ClientNotFoundException(cliente.getNome());
		else cliente.adicionaItemACompra(prato, quantidade);
			
	}
		
}
	
