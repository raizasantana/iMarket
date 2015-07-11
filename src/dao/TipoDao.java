package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tipo;

public class TipoDao {

	private Connection con;
	
	public TipoDao(){
		con = ConnectionFactory.getConexao();
	}
	
	
	public void adicionarTipo(Tipo t) throws SQLException{
		
		String sql = "insert into tipo(descricao,preco)" +
				" values (?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setString(1,t.getDescricao());
		stmt.setDouble(2,t.getPreco());
	
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	
	
	
	public void apagarTipo(Tipo t) throws SQLException{
		String sql = "delete from tipo where idtipo = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,t.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	
	
	public void alterarTipo(Tipo t) throws SQLException{
		
		String sql = "update tipo set idtipo = ?, descricao = ?, preco = ?" +
				" where idtipo = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setInt(1,t.getId());
		stmt.setString(2,t.getDescricao());
		stmt.setDouble(3,t.getPreco());
		
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	
	
	
	
	
	
	
	
	public Tipo getTipo(int id) throws SQLException{
		String sql = "select idtipo,descricao,preco from tipo where idtipo = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,id);
		
		ResultSet rs = stmt.executeQuery();
		Tipo t = null;
		
		if(rs.next()){
			t = new Tipo();
			
			t.setId(rs.getInt("idtipo"));
			t.setDescricao(rs.getString("descricao"));
			t.setPreco(rs.getDouble("preco"));			
			
		} 
		rs.close();
		stmt.close();
		con.close();
		return t;
	}
		
		public ArrayList<Tipo> getTipos() throws SQLException{
			String sql = "select idtipo,descricao,preco from tipo ";
			
			PreparedStatement stmt = con.prepareStatement(sql);
		
			
			ResultSet rs = stmt.executeQuery();
			
			Tipo t = null;
			ArrayList<Tipo> tipos = new ArrayList<Tipo>();
			
			while (rs.next()){
				t = new Tipo();
				
				t.setId(rs.getInt("idtipo"));
				t.setDescricao(rs.getString("descricao"));
				t.setPreco(rs.getDouble("preco"));			
				
				tipos.add(t);
			} 
			rs.close();
			stmt.close();
			con.close();
			return tipos;
			
	}

		
		
		
		
		
		
		
		
		
		
		
		public ArrayList<Tipo> getTipos(String descricao) throws SQLException{
			String sql = "select idtipo,descricao,preco from tipo where descricao like ? ";
	     	descricao = "%"+descricao + "%";
			PreparedStatement stmt = con.prepareStatement(sql);
		    stmt.setString(1, descricao);
			
			ResultSet rs = stmt.executeQuery();
			
			Tipo t = null;
			ArrayList<Tipo> tipos = new ArrayList<Tipo>();
			
			while (rs.next()){
				t = new Tipo();
				
				t.setId(rs.getInt("idtipo"));
				t.setDescricao(rs.getString("descricao"));
				t.setPreco(rs.getDouble("preco"));			
				
				tipos.add(t);
			} 
			rs.close();
			stmt.close();
			con.close();
			return tipos;
			
	}
}
