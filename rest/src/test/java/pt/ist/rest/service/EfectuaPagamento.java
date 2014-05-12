package pt.ist.rest.service;

import java.util.List;

import pt.ist.chequerefeicao.CheckAlreadyUsedException;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.InvalidCheckException;
import pt.ist.chequerefeicao.InvalidPayeeException;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.NegativeBalanceException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PagamentoDto;

public class EfectuaPagamento{


public int pagamentoDeCompra(String nomeCliente, List<String> cheques){
	
    int valorCheques = 0;
	ClienteDto cliente = new ClienteDto(nomeCliente,null);
		try {
		     valorCheques = ChequeRefeicao.cashChecks(nomeCliente, cheques);
		    
		    new ActualizaSaldoService(new PagamentoDto(cliente,cheques,valorCheques)).execute();
		    new RegistaPagamentoTabuleiroComprasService(cliente).execute();
		 
		    
		}
		 catch(InvalidPayeeException ice){
			 valorCheques = 1;
		}   
		catch(InvalidCheckException ice){
			 System.out.println("Could not make valid registry of checks!" + ice);
		}catch (CheckAlreadyUsedException cae) {
		    System.out.println("Could not make valid registry of checks!" + cae);
		} catch (ClientNotFoundException e){
			System.out.println(e.toString());
		} catch (NegativeBalanceException e){
			System.out.println(e.toString());
		}
		
	return valorCheques;	
	}


public int verificaCompra(String nomeCliente){
	
	ClienteDto cliente = new ClienteDto(nomeCliente,null);
	
	
	
	return 0;
}
  }
