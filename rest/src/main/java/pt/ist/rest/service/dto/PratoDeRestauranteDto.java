<<<<<<< HEAD

package pt.ist.rest.service.dto;



public class PratoDeRestauranteDto  extends PratoSimpleDto implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer calorias;
	private Integer preco;
	private Integer classificacao;
	private Integer quantidade;
	private String nomeRestaurante;

	public PratoDeRestauranteDto() {}
	
	public PratoDeRestauranteDto(String name,Integer calorias,Integer preco,int classificacao, String nomeRestaurante){
		super(name);
		this.calorias = calorias;
		this.preco = preco;
		this.classificacao = classificacao;
		this.nomeRestaurante=nomeRestaurante;
		}

	public int getQuantidade(){
		return quantidade; 
	}
	
   public String getAtributo() {
		return super.getAtributo();
	}

   public Integer getCalorias() {
	   return calorias;
   }
   
   
   public Integer getPreco() {
	   return preco;
   }
   
   
   public void setPreco(Integer preco) {
	   this.preco = preco;
   }
   
   
   public Integer getClassificacao() {
	   return classificacao;
   }
   
   
   public void setClassificacao(Integer classificacao) {
	   this.classificacao = classificacao;
   }


	public String getNomeRestaurante() {
		return nomeRestaurante;
	}


}

||||||| merged common ancestors

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

=======

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

>>>>>>> eb3ccbf757964cbe4a4b17d95d799ab3eeb5e2d9
