package pt.ist.rest.service.dto;



public class PratoDeRestauranteDto {
	private final String descricaoPrato;
	private final String nomeRestaurante;

	public PratoDeRestauranteDto(String descricaoPrato, String nomeRestaurante){
		this.descricaoPrato=descricaoPrato;
		this.nomeRestaurante=nomeRestaurante;
		}

	public String getDescricaoPrato() {
		return descricaoPrato;
	}

	public String getNomeRestaurante() {
		return nomeRestaurante;
	}


}