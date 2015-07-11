package model;

public class Tipo {
	
	private int id;
	private String descricao;
	private double preco;
	
	public double getPreco() {
		return preco;
	}
	public double setPreco(double preco) {
		return this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double calcularPreco(Tipo t){
		System.out.println("Fail");
		return getPreco();
		
	}
	
	
	
	

}
