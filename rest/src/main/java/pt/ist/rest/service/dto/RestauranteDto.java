package pt.ist.rest.service.dto;

public class RestauranteDto{

	private String morada;
	private String nome;
	
	public ClienteDto(String nome, String morada) {
		
		this.nome = nome;
		this.morada = morada;
		
	}
		
	public final String getMorada() {
		return morada;
	}
		
	public final String getNome() {
		return nome;
	}
}
	