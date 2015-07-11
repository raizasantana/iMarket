package model;

public class Ingresso {
	
	

	private Sessao sessao;
	private Cliente cliente;
	private Tipo tipo;
	private Cadeira cadeira;

	private int id;
	
	public Cadeira getCadeira() {
		return cadeira;
	}


	public void setCadeira(Cadeira cadeira) {
		this.cadeira = cadeira;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Ingresso() {
		super();
	}


	/* public Ingresso(double valor, Sessao sessao, Cliente cliente) {
		super();
		this.valor = valor;
		this.sessao = sessao;
		this.cliente = cliente;
	}*/


	


	


	public Sessao getSessao() {
		return sessao;
	}


	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	
	
	}
	
	

