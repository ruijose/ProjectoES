package pt.ist.rest.service.dto;



public class ItemDto{

	private String nomePrato;
	private int preco;
	private int id;
	private int quantidade;



	public ItemDto(String nome, int preco, int identificador, int quantidade) {

		this.nomePrato = nome;
		this.preco = preco;
		this.id = identificador;
		this.quantidade = quantidade;
	
	}

	public final String getNomePrato() {
		return nomePrato;
	}


	public final int getPreco() {
		return preco;
	}

	public final int getId() {
		return id;
	}

	public final int getQuantidade() {
		return quantidade;
	}

}
