package pt.ist.rest.service.dto;




public class PratoDto {

	private final String nomeP;
	private final Integer calorias;
	private Integer preco;
	private Integer classificacao;
	private Integer quantidade;




	public PratoDto(String name,Integer calorias,Integer preco,int quantidade,int classificacao){
		this.nomeP = name;
		this.calorias = calorias;
		this.preco = preco;
		this.classificacao = classificacao;
		this.quantidade = quantidade;

	}


  public int getQuantidade(){
		return quantidade; 
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


@Override
public String toString() {
	return "PratoDto [nomeP=" + nomeP + ", calorias=" + calorias + ", preco="
			+ preco + ", classificacao=" + classificacao + "]";
}
   
   
 }
