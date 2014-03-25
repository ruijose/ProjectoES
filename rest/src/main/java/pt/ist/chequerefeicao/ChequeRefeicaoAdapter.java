package pt.ist.chequerefeicao;

import java.util.List;

public class ChequeRefeicaoLocalAdapter implements ChequeRefeicaoTipo{

	public int cashChecks(String payee,List<String> checks) 
			throws InvalidCheckException, CheckAlreadyUsedException, InvalidPayeeException;
	
}
