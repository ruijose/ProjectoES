package pt.ist.chequerefeicao;
import java.util.List;

/**
 *	Esta classe abastrai a implemtentacao do tipo de cheques usados, local ou remoto.
 *	@see pt.ist.chequeRefeicao.ChequeRefeicaoTipo
 *	@see pt.ist.chequeRefeicao.ChequeRefeicaoLocal
 */

public class ChequeRefeicao {
	
	private ChequeRefeicaoTipo chequeRefeicaoTipo;
	
	/**
	 * 	Construtor de cheque, recebe a implementacao de cheques a usar
	 */
	
	public ChequeRefeicao(ChequeRefeicaoTipo chequeRefeicaoTipo){
		this.chequeRefeicaoTipo = chequeRefeicaoTipo;
	}
	/**
	 * 	Faz o pagamento dos Cheques.
	 * 	Dependendo do tipo de cheques a usar o tipo de excepcoes lancadas sao diferentes.
	 * 
	 * @param payee		dono dos cheques
	 * @param checks 	valor dos cheques
	 * @return int 		valor total dos cheques usados
	 * 
	 * 
	 *
	 * @see pt.ist.chequerefeicao.InvalidCheckException
	 * @see pt.ist.chequerefeicao.CheckAlreadyUsedException
	 */
	public int cashChecks(String payee,List<String> checks) throws InvalidCheckException, CheckAlreadyUsedException {
		return this.chequeRefeicaoTipo.cashChecks(payee,checks);
	}
	
}
