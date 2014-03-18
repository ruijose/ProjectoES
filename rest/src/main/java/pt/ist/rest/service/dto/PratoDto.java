package pt.ist.rest.service.dto;




public class PratoDto {

	private final String nomeP;
	private final Integer calorias;
	private Integer preco;
	private Integer classificacao;




	public PratoDto(String name,Integer calorias,Integer preco,int classificacao){
		this.nomeP = name;
		this.calorias = calorias;
		this.preco = preco;
		this.classificacao = classificacao;

	}


   public String getNomeP() {
		return nomeP;
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
   
 }
