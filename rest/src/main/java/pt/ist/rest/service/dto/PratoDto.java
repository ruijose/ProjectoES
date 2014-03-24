package pt.ist.rest.service.dto;




public class PratoDto extends PratoSimpleDto {

	
	private final Integer calorias;
	private Integer preco;
	private Integer classificacao;
	private Integer quantidade;



   public PratoDto(String name,Integer calorias,Integer preco,int classificacao){
		super(name);
		this.calorias = calorias;
		this.preco = preco;
		this.classificacao = classificacao;
	

	}
	

  public int getQuantidade(){
		return quantidade; 
	}
	
   public String getNome() {
		return super.getNomeP();
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
	return "PratoDto [nomeP=" + getNome() + ", calorias=" + calorias + ", preco="
			+ preco + ", classificacao=" + classificacao + "]";
}
   
   
 }
