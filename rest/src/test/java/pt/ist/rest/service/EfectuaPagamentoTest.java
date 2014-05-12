package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

import pt.ist.chequerefeicao.CheckAlreadyUsedException;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.InvalidCheckException;
import pt.ist.chequerefeicao.InvalidPayeeException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PagamentoDto;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class EfectuaPagamentoTest{
       
	    @Mocked 
		private ChequeRefeicao cheque;
		
		@Test
		public void RealizaPagamentoTestInvalidCheque() throws InvalidPayeeException,CheckAlreadyUsedException,InvalidCheckException {
		
		int ref = 1;	
		final String nomeCliente ="zeze";
		final List<String> cheques = new ArrayList<String>(); 
        cheques.add("A");
		
        EfectuaPagamento pagamento = new EfectuaPagamento();
				  
		  
		new Expectations() {{ 
	    	  ChequeRefeicao.cashChecks(nomeCliente, cheques);
			  result = new InvalidPayeeException(nomeCliente);
        }};
		
       int result = pagamento.pagamentoDeCompra(nomeCliente, cheques);
	   assertEquals(ref,result);
       
	}
	
	
}