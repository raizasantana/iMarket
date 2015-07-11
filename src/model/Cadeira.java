package model;

public class Cadeira {
	private int id;
	private String nome; // linha + coluna
    private int status;// status =1 est� disponivel qualquer valor diferente est� ocupada
	private Sala sala;
	private int numero;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
	
}

/*
CADEIRA:


/PARA A ORGANIZA��O DA VENDA DE CADEIRAS RESERVADAS!

ATRIBUTOS:
-nome(linha e coluna, por ordem alfab�tica);
-sala(do tipo Sala);

-ser� ligada a sala;
	*receber os dados de Sala
-e ligada a ingresso;
	ser� add dados na compra do ingresso
*/