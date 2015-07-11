package model;

public class Filme {
	
	private String nome,  sinopse;
	private String dataIni, dataFin;
	private int duracao, censura;
	private int id;
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Filme() {
		super();
	}
	

	public Filme(String nome, String dataIni) {
		super();
		this.nome = nome;
		this.dataIni = dataIni;
	}



	public Filme(String nome, int censura, String sinopse, String dataIni,
			String dataFin, int duracao) {
		super();
		this.nome = nome;
		this.censura = censura;
		this.sinopse = sinopse;
		this.dataIni = dataIni;
		this.dataFin = dataFin;
		this.duracao = duracao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCensura() {
		return censura;
	}

	public void setCensura(int censura) {
		this.censura = censura;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDataIni() {
		return dataIni;
	}

	public void setDataIni(String dataIni) {
		this.dataIni = dataIni;
	}

	public String getDataFin() {
		return dataFin;
	}

	public void setDataFin(String dataFin) {
		this.dataFin = dataFin;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
	

}
