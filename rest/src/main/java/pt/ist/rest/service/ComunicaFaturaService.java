package pt.ist.rest.service;

import java.util.*;

import pt.ist.registofatura.RegistoFaturaLocal;
import pt.ist.rest.domain.Cliente;
import pt.ist.rest.domain.Rest;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.service.dto.ClienteDto;
import pt.ist.rest.domain.Compra;
import pt.ist.registofatura.ws.ClienteInexistente_Exception;
import pt.ist.registofatura.ws.Fatura;
import pt.ist.registofatura.ws.EmissorInexistente_Exception;
import pt.ist.registofatura.ws.FaturaInvalida_Exception;
import pt.ist.registofatura.ws.Serie;
import pt.ist.registofatura.ws.TotaisIncoerentes_Exception;

public class ComunicaFaturaService extends RestService{
	private int numeroSequencia = 1;
	private int numeroSerie;
	private RegistoFaturaLocal registoFatura;
	final private ClienteDto clienteDto;
	private Serie serie;
	final private Rest rest = FenixFramework.getRoot();
	private static final String NOME_EMISSOR = "Portal";

	public ComunicaFaturaService(ClienteDto cliente) {
		this.registoFatura = rest.getRegistoFatura();
		this.clienteDto = cliente;
		this.numeroSerie=rest.getUltimaSerie();
		this.numeroSequencia=rest.getUltimoSeqNumber();
		this.registoFatura=rest.getRegistoFatura();
	}

	public final void dispatch(){
		
		final Cliente cliente = rest.procuraClientePorNome(this.clienteDto.getUser());
		final Compra compra = cliente.getCompraAberta();
		final Fatura fatura = compra.getFatura();
		
		fatura.setNifCliente(cliente.getNif());
		fatura.setNomeEmissor(cliente.getNome());
		fatura.setIva(rest.getIVA());
        fatura.setNifEmissor(rest.getNif());
        fatura.setNomeEmissor(NOME_EMISSOR);
		try{
			if(numeroSequencia == 4){
				serie = registoFatura.pedirSerie(1212);
				numeroSequencia=1;
			}
			else numeroSequencia++;


		}catch(EmissorInexistente_Exception e){
			System.out.println(e.getMessage() + "  -- " + e.getClass());
		}

		fatura.setNumSeqFatura(numeroSequencia);
		fatura.setNumSerie(numeroSerie);
		rest.setUltimoSeqNumber(numeroSequencia);
		rest.setUltimaSerie(numeroSerie);
	
		try{
			registoFatura.comunicarFatura(fatura);
			
		}catch(EmissorInexistente_Exception e){
			System.out.println(e.getMessage() + "  -- " + e.getClass());
		}
		catch(TotaisIncoerentes_Exception e){
			System.out.println(e.getMessage() + "  -- " + e.getClass());
		}
		catch(ClienteInexistente_Exception e){
			System.out.println(e.getMessage() + "  -- " + e.getClass());
		}
		catch(FaturaInvalida_Exception e){
			System.out.println(e.getMessage() + "  -- " + e.getClass());
		}

	}
}
	

