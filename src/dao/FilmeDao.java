package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;

public class FilmeDao {

		public Connection con;
		
		public FilmeDao(){
			con = ConnectionFactory.getConexao();
		}
		
		public void adicionarFilme(Filme f) throws SQLException{
			
			String sql = "insert into filme(nome,censura,sinopse,dataini,datafin,duracao)" +
					" values (?,?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			

			stmt.setString(1,f.getNome());
			stmt.setInt(2,f.getCensura());
			stmt.setString(3,f.getSinopse());
			stmt.setString(4,f.getDataIni());
			stmt.setString(5,f.getDataFin());
			stmt.setInt(6,f.getDuracao());
			
			stmt.execute();
			
			stmt.close();
			
			con.close();
			
		}
		
		
		
		public void apagarFilme(Filme f) throws SQLException{
			String sql = "delete from filme where id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,f.getId());
			
			stmt.execute();
			
			stmt.close();
			
			con.close();
			
		}
		
		
	public void alterarFilme(Filme f) throws SQLException{
			
			String sql = "update filme set nome = ?, censura = ?, sinopse = ?, dataini = ?, datafin = ?, duracao = ? " +
					" where id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,f.getNome());
			stmt.setInt(2,f.getCensura());
			stmt.setString(3,f.getSinopse());
			stmt.setString(4,f.getDataIni());
			stmt.setString(5,f.getDataFin());
			stmt.setInt(6,f.getDuracao());
			
			stmt.setInt(7,f.getId());
			
			stmt.execute();
			
			stmt.close();
			
			con.close();
			
		}
	
	public Filme getFilme(int id) throws SQLException{
		String sql = "select idfilme,nome,censura,sinopse,dataini,datafin,duracao from filme " +
		" where idfilme = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,id);
		
		//ResultSet, vai abrir uma gread com os resultados do select
		ResultSet rs = stmt.executeQuery();
		
		Filme f = null;
		
		if (rs.next()){
			
		f = new Filme();
		f.setId(rs.getInt("idfilme"));
		f.setNome(rs.getString("nome"));
		f.setCensura(rs.getInt("censura"));
		f.setSinopse(rs.getString("sinopse"));
		f.setDataIni(rs.getString("dataini"));
		f.setDataFin(rs.getString("datafin"));
		f.setDuracao(rs.getInt("duracao"));
		
		}
		rs.close();
		stmt.close();
		con.close();
		return f;
		
		}
	
	public ArrayList<Filme> getFilmes() throws SQLException{
		
		String sql = "select idfilme,nome,censura,sinopse,dataini,datafin,duracao from filme ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		//ResultSet, vai abrir uma gread com os resultados do select
		
		ResultSet rs = stmt.executeQuery();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		Filme f = null;
		
		while (rs.next()){
			
			f = new Filme();
			
			f.setId(rs.getInt("idfilme"));
			f.setNome(rs.getString("nome"));
			f.setCensura(rs.getInt("censura"));
			f.setSinopse(rs.getString("sinopse"));
			f.setDataIni(rs.getString("dataini"));
			f.setDataFin(rs.getString("datafin"));
			f.setDuracao(rs.getInt("duracao"));
			
			filmes.add(f);
		}
		rs.close();
		stmt.close();
		con.close();
		return filmes;
		
		}
	
	
	public ArrayList<Filme> getFilmes(String nome) throws SQLException{
		
		String sql = "select idfilme,nome,censura,sinopse,dataini,datafin,duracao from filme where nome like ? ";
		nome = "%"+nome + "%";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,nome);
		
		//ResultSet, vai abrir uma gread com os resultados do select
		ResultSet rs = stmt.executeQuery();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		Filme f  = null;
		
		while (rs.next()){
			
			f = new Filme();
			
			f.setId(rs.getInt("idfilme"));
			f.setNome(rs.getString("nome"));
			f.setCensura(rs.getInt("censura"));
			f.setSinopse(rs.getString("sinopse"));
			f.setDataIni(rs.getString("dataini"));
			f.setDataFin(rs.getString("datafin"));
			f.setDuracao(rs.getInt("duracao"));
			
			filmes.add(f);
		} 
		rs.close();
		stmt.close();
		con.close();
		return filmes;
		}	
		
}
