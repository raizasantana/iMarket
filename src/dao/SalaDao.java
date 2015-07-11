package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Sala;

public class SalaDao {
	Connection con;
	
	public SalaDao(){		
		 con = ConnectionFactory.getConexao();
	}
	
	public void adicionarSala(Sala s) throws SQLException{
		String sql = "insert into sala(qtdcadeiras,qtdfileiras,nome) values(?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
	
		stmt.setInt(1,s.getQtdCadeiras());
		stmt.setInt(2, s.getQtdFileiras());
		stmt.setString(3,s.getNome());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	public void apagarSala(Sala s) throws SQLException{
		String sql = "delete from sala where idsala = ?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,s.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
		
	}
	
	public void alterarSala(Sala s) throws SQLException{
		
		String sql = "update sala set qtdcadeiras = ?,qtdfileiras = ?, nome = ?  where idsala = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,s.getQtdCadeiras());
		stmt.setInt(2, s.getQtdFileiras());
		stmt.setString(3,s.getNome());		
		stmt.setInt(4,s.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	
	public Sala getSala(int id) throws SQLException{
		String sql = "select idsala,qtdcadeiras,qtdfileiras,nome from sala  where idsala = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,id);
		
		//ResultSet, vai abrir uma gread com os resultados do select
		ResultSet rs = stmt.executeQuery();
		
		Sala s = null;
		
		if (rs.next()){
			
		s = new Sala();
		s.setId(rs.getInt("idsala"));
		s.setQtdCadeiras(rs.getInt("qtdcadeiras"));
		s.setQtdFileiras(rs.getInt("qtdfileiras"));
		s.setNome(rs.getString("nome"));
		
		} 
		rs.close();
		stmt.close();
		con.close();
		return s;
		
		}
	
	public ArrayList<Sala> getSalas() throws SQLException{
		
		String sql = "select idsala,qtdcadeiras,qtdfileiras,nome from sala ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		//ResultSet, vai abrir uma gread com os resultados do select
		
		ResultSet rs = stmt.executeQuery();
		ArrayList<Sala> salas = new ArrayList<Sala>();
		
		Sala s = null;
		
		while (rs.next()){
			
			s = new Sala();
			
			s.setId(rs.getInt("idsala"));
			s.setQtdCadeiras(rs.getInt("qtdcadeiras"));
			s.setQtdFileiras(rs.getInt("qtdfileiras"));
			s.setNome(rs.getString("nome"));
			
			salas.add(s);
		} 
		rs.close();
		stmt.close();
		con.close();
		return salas;
		
		}
	
	public ArrayList<Sala> getSalas(String nome) throws SQLException{
		
		String sql = "select idsala,qtdcadeiras,qtdfileiras,nome from sala where nome like ? ";
		nome = "%"+nome + "%";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,nome);
		
		//ResultSet, vai abrir uma gread com os resultados do select
		ResultSet rs = stmt.executeQuery();
		ArrayList<Sala> salas = new ArrayList<Sala>();
		
	    Sala s = null;
		
		while (rs.next()){
			
			s = new Sala();
			
			s.setId(rs.getInt("idsala"));
			s.setQtdCadeiras(rs.getInt("qtdcadeiras"));
			s.setQtdFileiras(rs.getInt("qtdfileiras"));
			s.setNome(rs.getString("nome"));
			
			salas.add(s);
		} 
		rs.close();
		stmt.close();
		con.close();
		return salas;
		
		}


	
	
	

}
