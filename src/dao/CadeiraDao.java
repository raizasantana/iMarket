package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cadeira;
import model.Sala;
import model.Sessao;


public class CadeiraDao {
	
	private Connection con;
	
	
	public CadeiraDao(){
		con = ConnectionFactory.getConexao();
	}
	
	public void adicionarCadeira(Cadeira cad) throws SQLException{
		if (cad.getSala().getQtdCadeiras()>=this.getQtdCadeira(cad.getSala())){
		//questionar o professor sobre a melhor forma de fazer a limitação das cadeiras	por sala
			/****************
			 *
			 */
		con = ConnectionFactory.getConexao();
		
		String sql = " insert into cadeira(nome,numero,idsala) values(?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setString(1,cad.getNome());
		stmt.setInt(2, cad.getNumero());
		stmt.setInt(3,cad.getSala().getId());
		
		stmt.execute();
		
		
		stmt.close();
		
		con.close();
		
		
		}
		
	}
	
	public void adicionarTodas (int idsala,String nome,int numeroinicial,int numerofinal) throws SQLException {
	
		SalaDao sdao=new SalaDao();
		Sala sala=sdao.getSala(idsala);
		for (int i=0; i<=numerofinal;i++){
		Cadeira cad=new Cadeira();	
		int numeronome=numeroinicial+i;
	    
		cad.setNome(nome);
		cad.setSala(sala);
		cad.setNumero(numeronome);
		
		
		con = ConnectionFactory.getConexao();
		String sql = " insert into cadeira(nome,numero,idsala) values(?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1,cad.getNome());
		stmt.setInt(2, cad.getNumero());
		stmt.setInt(3,cad.getSala().getId());
		
		stmt.execute();
		
		
		stmt.close();
		
		con.close();
		
	}}
	
	
	
	public void apagarCadeira(Cadeira cad) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = " delete from cadeira where idcadeira = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,cad.getId());

		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	public int getQtdCadeira(Sala sala) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql="select count(*) from cadeira where idsala=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sala.getId());
		ResultSet rs = ps.executeQuery();
		
		int qtd=0;
		if (rs.next()){
			qtd=rs.getInt("count");
		}
		rs.close();
		ps.close();
		con.close();
		return qtd;
	}
	
	
	
	
	public Cadeira getCadeira(int id) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = " select idcadeira,nome,numero,idsala from cadeira where idcadeira = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,id);
		
		ResultSet rs = stmt.executeQuery();
		
		Cadeira cad = null;
		
		if (rs.next()){
            cad = new Cadeira();
			
			cad.setId(rs.getInt("idcadeira"));
			cad.setNome(rs.getString("nome"));
			cad.setNumero(rs.getInt("numero"));
			
			Sala sala = null;
			SalaDao salaDao = new SalaDao();			
			sala = salaDao.getSala(rs.getInt("idsala"));
			
			cad.setSala(sala);
			
		
		
			
		
		}
		
		rs.close();
		stmt.close();
		con.close();
		return cad;
		
	}
	
	public ArrayList<Cadeira> getCadeirasSala(int idsala) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = " select idcadeira,nome,idsala,numero from cadeira where idsala= ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,idsala);
		
		ResultSet rs = stmt.executeQuery();
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		
		Cadeira cad = null;
		
		while (rs.next()){
            cad = new Cadeira();
			
			cad.setId(rs.getInt("idcadeira"));
			cad.setNome(rs.getString("nome"));
			cad.setNumero(rs.getInt("numero"));
			
			Sala sala = null;
			SalaDao salaDao = new SalaDao();			
			sala = salaDao.getSala(rs.getInt("idsala"));
			cad.setSala(sala);
			
			
			
			cadeiras.add(cad);
		}
		rs.close();
		stmt.close();
		con.close();
		return cadeiras;
		
	}
	
	
	
	
	public ArrayList<Cadeira> getDisponiveis() throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "SELECT idcadeira,nome,idsala,numero FROM cadeira where  idcadeira NOT IN (SELECT idcadeira FROM ingresso)";
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
	
		
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		Cadeira cad = null;
		
		while (rs.next()){
			cad = new Cadeira();
			
			cad.setId(rs.getInt("idcadeira"));
			cad.setNome(rs.getString("nome"));
			cad.setNumero(rs.getInt("numero"));
			
			Sala sala = null;
			SalaDao salaDao = new SalaDao();			
			sala = salaDao.getSala(rs.getInt("idsala"));
			cad.setSala(sala);
		
			
			cadeiras.add(cad);
			
		}
		rs.close();
		stmt.close();
		con.close();
		return cadeiras;
		
	}
		
	

	public ArrayList<Cadeira> getDisponiveis(Sessao sessao) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "SELECT idcadeira,nome,idsala,numero FROM cadeira where  idcadeira NOT IN (SELECT idcadeira FROM ingresso where ingresso.idsessao = ?) and idsala = ?";
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, sessao.getId());
		stmt.setInt(2, sessao.getSala().getId());
	
		
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		Cadeira cad = null;
		
		while (rs.next()){
			cad = new Cadeira();
			
			cad.setId(rs.getInt("idcadeira"));
			cad.setNome(rs.getString("nome"));
			cad.setNumero(rs.getInt("numero"));
			
			Sala sala = null;
			SalaDao salaDao = new SalaDao();			
			sala = salaDao.getSala(rs.getInt("idsala"));
			cad.setSala(sala);
		    cad.setStatus(1);
			
			cadeiras.add(cad);
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		return cadeiras;
		
	}
		
	
}

