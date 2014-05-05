
package pt.ist.rest.service.dto;



public class PratoDeRestauranteDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String descricaoPrato;
	private String nomeRestaurante;

	public PratoDeRestauranteDto() {}
	
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

