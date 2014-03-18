package pt.ist.rest.service.dto;

public class RestauranteSimpleDto{

	private String morada;
	private String nome;
	private int classificacao;
	
	public RestauranteSimpleDto(String nome, String morada,int classificacao) {
		
		this.nome = nome;
		this.morada = morada;
		this.classificacao = classificacao; 
		
	}
	
	public int getClassificacao() {
		return classificacao;
	}
		
	public final String getMorada() {
		return morada;
	}
		
	public final String getNome() {
		return nome;
	}
}
	