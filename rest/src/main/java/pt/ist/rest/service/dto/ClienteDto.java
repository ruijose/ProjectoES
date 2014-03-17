package pt.ist.rest.service.dto;

public class ClienteDto extends UtilizadorDto{

	private String mail;
	private String morada;
	private String nome;
	
	public ClienteDto(String user, String pass, String nome, String morada, String mail) {
		
		super(user, pass);
		this.nome = nome;
		this.morada = morada;
		this.mail = mail;
		
	}
	
	public final String getMail() {
		return mail;
	}
	
	
	public final String getMorada() {
		return morada;
	}
	
	
	public final String getNome() {
		return nome;
	}
}
	