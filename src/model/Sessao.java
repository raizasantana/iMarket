package model;

import java.sql.Date;

public class Sessao {

	private Date data;
	private String horaIni; 
	private Sala sala;
	private Filme filme;
	private int id;
	
	public Sessao(){
	
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Sessao(Sala sala, Filme filme) {
		super();
		this.sala = sala;
		this.filme = filme;
	}



	public Sessao(Date data, String horaIni, Sala sala, Filme filme) {
		super();
		this.data = data;
		this.horaIni = horaIni;
		this.sala = sala;
		this.filme = filme;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(String string) {
		this.horaIni = string;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
 
	
	
	
}
