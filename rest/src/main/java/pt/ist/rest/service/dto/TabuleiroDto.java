package pt.ist.rest.service.dto;


import java.util.List;

public class TabuleiroDto {

	private int saldo;
	private int custo;
	private List<ItemDto> items; 

	public TabuleiroDto(int custo,int saldo,List<ItemDto> dto){
		this.items = dto;
		this.custo = custo;
		this.saldo = saldo;
	}

	public List<ItemDto> getItems(){
		return this.items;
	}

	public int getSaldo() {
		return saldo;
	}

	public int getCusto() {
		return custo;
	}


}
