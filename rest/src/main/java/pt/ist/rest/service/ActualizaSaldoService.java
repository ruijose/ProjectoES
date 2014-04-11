package pt.ist.rest.service;

import java.util.List;

import pt.ist.chequerefeicao.CheckAlreadyUsedException;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.ChequeRefeicaoLocal;
import pt.ist.chequerefeicao.InvalidCheckException;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.NegativeBalanceException;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.service.dto.PagamentoDto;

public class ActualizaSaldoService extends RestService{

	private PagamentoDto pagamentoDto;


	public ActualizaSaldoService(PagamentoDto dto) {

		this.pagamentoDto = dto;

	}

	public final void dispatch() throws ClientNotFoundException, NegativeBalanceException{
		final Rest rest = FenixFramework.getRoot();
		final Cliente cliente = rest.procuraClientePorNome(this.pagamentoDto.clienteDto.getUser());

		ChequeRefeicao chequeRefeicao = new ChequeRefeicao(new ChequeRefeicaoLocal());
		
        int valorCheques = 0;
		
		try{
			valorCheques = chequeRefeicao.cashChecks(this.pagamentoDto.clienteDto.getUser(), this.pagamentoDto.cheques);
		}catch (InvalidCheckException ice) {
		    System.out.println("Could not make valid registry of checks! " + ice);
		} catch (CheckAlreadyUsedException cae) {
		    System.out.println("Could not make valid registry of checks!" + cae);
		}
		
		int valorTotal = valorCheques - this.pagamentoDto.custo;
		System.out.println("valor total: "+ valorTotal +  "  Cheque : "+ valorCheques + "  custo: "+ this.pagamentoDto.custo);
		cliente.addSaldo(valorTotal);	
	}

}

		

