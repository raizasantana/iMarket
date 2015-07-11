package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Filme;
import model.Sala;
import model.Sessao;

public class SessaoDao {
	
	public Connection con;
	
	public SessaoDao(){
		con = ConnectionFactory.getConexao();
	}
	
	public void adicionarSessao(Sessao s) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		//insert sessao(idsessao,idfilme,idsala,hora,data) values(2,1,2,"18:00","15-07-2011");
		String sql = "insert into sessao(idfilme,idsala,hora,data) values(?,?,?,?) ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setInt(1,s.getFilme().getId());
		stmt.setInt(2,s.getSala().getId());
		stmt.setString(3,s.getHoraIni());
		stmt.setDate(4,s.getData());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	public void apagarSessao(Sessao s) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		String sql = "delete from sessao where idsessao = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,s.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
public void alterarSessao(Sessao s)throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		//sessao(idsessao,idfilme,idsala,hora,data)
		String sql = "update sessao set idfilme = ?, idsala = ?, hora = ?, data = ? where idsessao = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,s.getFilme().getId());
		stmt.setInt(2,s.getSala().getId());
		stmt.setString(3,s.getHoraIni());		
		stmt.setInt(4,s.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}

public Sessao getSessao(int id) throws SQLException{
	

	con = ConnectionFactory.getConexao();
	
	//sessao(idsessao,idfilme,idsala,hora,data)
	String sql = "select idsessao,idfilme,idsala,hora,data from sessao where idsessao = ?";
	
	PreparedStatement stmt = con.prepareStatement(sql);
	
	stmt.setInt(1,id);
	
	//ResultSet, vai abrir uma gread com os resultados do select
	ResultSet rs = stmt.executeQuery();
	
	Sessao s = null;
	
	if (rs.next()){
		
	s = new Sessao();
	s.setId(rs.getInt("idsessao"));
	
	//Buscando filme
	Filme f = new Filme();
	f.setId(rs.getInt("idfilme"));
	
	FilmeDao fDao = new FilmeDao();
	Filme fi = new Filme();
	fi = fDao.getFilme(f.getId());
	s.setFilme(fi);
	
	//Buscando sala
	Sala sala = new Sala();
	SalaDao salaDao = new SalaDao();
	
	sala.setId(rs.getInt("idsala"));
	Sala sl = new Sala();
	sl = salaDao.getSala(sala.getId());
	s.setSala(sl);
	
	s.setHoraIni(rs.getString("hora"));
	s.setData(rs.getDate("data"));
	
	} 
	rs.close();
	stmt.close();
	con.close();
	return s;
	 
	}

	public ArrayList<Sessao> getSessoes() throws SQLException{	

	con = ConnectionFactory.getConexao();
	
	//sessao(idsessao,idfilme,idsala,hora,data)
	String sql = "select idsessao,idfilme,idsala,hora,data from sessao ";
	
	PreparedStatement stmt = con.prepareStatement(sql);	
	
	//ResultSet, vai abrir uma gread com os resultados do select
	ResultSet rs = stmt.executeQuery();
	
	Sessao s = null;
	ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
	
	while (rs.next()){
		
	s = new Sessao();
	s.setId(rs.getInt("idsessao"));
	
	//Buscando filme
	Filme f = new Filme();
	f.setId(rs.getInt("idfilme"));
	
	FilmeDao fDao = new FilmeDao();
	Filme fi = new Filme();
	fi = fDao.getFilme(f.getId());
	s.setFilme(fi);
	
	//Buscando sala
	Sala sala = new Sala();
	SalaDao salaDao = new SalaDao();
	
	sala.setId(rs.getInt("idsala"));
	Sala sl = new Sala();
	sl = salaDao.getSala(sala.getId());
	s.setSala(sl);
	
	s.setHoraIni(rs.getString("hora"));
	s.setData(rs.getDate("data"));
	
	sessoes.add(s);
	
	} 
	rs.close();
	stmt.close();
	con.close();
	return sessoes;
	 
	}
	
	public ArrayList<Sessao> getSessoesFilme(int idfilme) throws SQLException{	

		con = ConnectionFactory.getConexao();
		
		
		String sql = "select idsessao,idfilme,idsala,hora,data from sessao where idfilme = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);	
		stmt.setInt(1,idfilme);
		
		//ResultSet, vai abrir uma gread com os resultados do select
		ResultSet rs = stmt.executeQuery();
		
		Sessao s = null;
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		
		while (rs.next()){
			
		s = new Sessao();
		s.setId(rs.getInt("idsessao"));
		
		//Buscando filme		
		FilmeDao fDao = new FilmeDao();
		Filme fi = new Filme();
		fi = fDao.getFilme(rs.getInt("idfilme"));
		s.setFilme(fi);
		
		//Buscando sala
		SalaDao salaDao =new SalaDao();
		Sala sl = new Sala();		
		sl = salaDao.getSala(rs.getInt("idsala"));
		s.setSala(sl);
		
		
		
		
		s.setHoraIni(rs.getString("hora"));
		s.setData(rs.getDate("data"));
		
		sessoes.add(s);
		
		} 
		rs.close();
		stmt.close();
		con.close();
		return sessoes;
		 
		}
	
	}


