package pt.ist.rest.service;

import java.util.List;

import pt.ist.chequerefeicao.CheckAlreadyUsedException;
import pt.ist.chequerefeicao.ChequeRefeicao;
import pt.ist.chequerefeicao.InvalidCheckException;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.*;
import pt.ist.rest.exception.ClientNotFoundException;
import pt.ist.rest.exception.NegativeBalanceException;
import pt.ist.rest.service.dto.*;

public class ActualizaSaldoService extends RestService{

	private ChequesDto cheques;


	public ActualizaSaldoService(ChequesDto dto) {

		this.cheques = dto;

	}

	public final void dispatch() throws ClientNotFoundException, 
										pt.ist.rest.exception.InvalidCheckException,
										pt.ist.rest.exception.CheckAlreadyUsedException{
		final Rest rest = FenixFramework.getRoot();
		final Cliente cliente = rest.procuraClientePorNome(this.cheques.clienteDto.getUser());

		
        int valorCheques = 0;
		
		try{
			cliente.addSaldo(valorCheques);	//escrita 
			valorCheques = ChequeRefeicao.cashChecks(this.cheques.clienteDto.getUser(), this.cheques.cheques);
		} catch (InvalidCheckException ice) {
			throw new pt.ist.rest.exception.InvalidCheckException(ice.toString());
		} catch (CheckAlreadyUsedException cae) {
			throw new pt.ist.rest.exception.CheckAlreadyUsedException(cae.toString());
		}
		
		cliente.addSaldo(valorCheques);

	}

}

		

