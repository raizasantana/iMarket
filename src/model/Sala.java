package model;

public class Sala {
	
	private int qtdCadeiras;
	private int qtdFileiras;
	private String nome;
	private int id;
	

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala() {
		super();
	}

	public Sala(int qtdCadeiras, String nome) {
		super();
		this.qtdCadeiras = qtdCadeiras;
		this.nome = nome;
	}

	public int getQtdCadeiras() {
		return qtdCadeiras;
	}

	public void setQtdCadeiras(int qtdCadeiras) {
		this.qtdCadeiras = qtdCadeiras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQtdFileiras(int qtdFileiras) {
		this.qtdFileiras = qtdFileiras;
	}

	public int getQtdFileiras() {
		return qtdFileiras;
	}
	
	
}
