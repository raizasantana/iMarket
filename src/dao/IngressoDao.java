package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cadeira;
import model.Cliente;
import model.Ingresso;
import model.Sessao;
import model.Tipo;

public class IngressoDao {
	
	private Connection con;
	
	public IngressoDao(){
		con = ConnectionFactory.getConexao();
	}
	
	public void adicionarIngresso(Ingresso i) throws SQLException{		
		con = ConnectionFactory.getConexao();
		String sql = "insert into ingresso(idtipo,idsessao,idcliente,idcadeira) values(?,?,?,?)";		
		PreparedStatement stmt = con.prepareStatement(sql);
		
	
    	stmt.setInt(1,i.getTipo().getId());
		stmt.setInt(2,i.getSessao().getId());
		stmt.setInt(3,i.getCliente().getId());				
		stmt.setInt(4,i.getCadeira().getId());
		
		stmt.execute();		
		stmt.close();		
		con.close();
		
	}
	
	
	
	public Ingresso getIngresso(int idingresso) throws SQLException {
		String sql= "select idingresso,idtipo,idsessao,idcliente,idcadeira from ingresso where idingresso=? ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,idingresso);		
		ResultSet rs = stmt.executeQuery();
		Ingresso i=null;
		if (rs.next()){
			
		
		i = new Ingresso();
		
		i.setId(rs.getInt("idingresso"));
		
		//Buscando cadeira
		Cadeira cad = new Cadeira();
		cad.setId(rs.getInt("idcadeira"));
		
		CadeiraDao cDao = new CadeiraDao();
		Cadeira cade = new Cadeira();
		cade = cDao.getCadeira(cad.getId());
		i.setCadeira(cade);
		
		//Buscando cliente
		Cliente cli = new Cliente();
		ClienteDao cliDao = new ClienteDao();
		
		cli.setId(rs.getInt("idcliente"));
		Cliente cl=new Cliente();
		cl = cliDao.getCliente(cli.getId());			
		i.setCliente(cl);
					
		//Buscando sessao
		Sessao ses = new Sessao();
		SessaoDao sesDao = new SessaoDao();
		ses.setId(rs.getInt("idsessao"));
		Sessao se = new Sessao();
		se = sesDao.getSessao(ses.getId());
		i.setSessao(se);

		//Buscando sessao tipo
		Tipo tip = new Tipo();
		TipoDao tipDao = new TipoDao();
		tip.setId(rs.getInt("idtipo"));
		Tipo ti = new Tipo();
		ti = tipDao.getTipo(tip.getId());
		i.setTipo(ti);
	
		}
		rs.close();
		stmt.close();
		con.close();
		
		return i;
		
	}
	
	
	
	
	

	public ArrayList<Ingresso> getIngressos(int idsessao) throws SQLException{
		
		String sql = "select idingresso,idtipo,idsessao,idcliente,idcadeira from ingresso where idsessao=? ";	
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,idsessao);		
		//ResultSet, vai abrir uma grid com os resultados do select
		ResultSet rs = stmt.executeQuery();
		
	    Ingresso i = null;
	    ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();
	    
		while (rs.next()){
	    
		    i = new Ingresso();
			i.setId(rs.getInt("idingresso"));
			
			//Buscando cadeira
			Cadeira cad = new Cadeira();
			cad.setId(rs.getInt("idcadeira"));
			
			CadeiraDao cDao = new CadeiraDao();
			Cadeira cade = new Cadeira();
			cade = cDao.getCadeira(cad.getId());
			i.setCadeira(cade);
			
			//Buscando cliente
			Cliente cli = new Cliente();
			ClienteDao cliDao = new ClienteDao();
			
			cli.setId(rs.getInt("idcliente"));
			Cliente cl=new Cliente();
			cl = cliDao.getCliente(cli.getId());			
			i.setCliente(cl);
						
			//Buscando sessao
			Sessao ses = new Sessao();
			SessaoDao sesDao = new SessaoDao();
			ses.setId(rs.getInt("idsessao"));
			Sessao se = new Sessao();
			se = sesDao.getSessao(ses.getId());
			i.setSessao(se);

			//Buscando sessao tipo
			Tipo tip = new Tipo();
			TipoDao tipDao = new TipoDao();
			tip.setId(rs.getInt("idtipo"));
			Tipo ti = new Tipo();
			ti = tipDao.getTipo(tip.getId());
			i.setTipo(ti);
		
			ingressos.add(i);
		} 
		rs.close();
		stmt.close();
		con.close();
		return ingressos;
		
		}
	
	
	
	
	
	
	
	
	
	
        public ArrayList<Ingresso> getIngressos() throws SQLException{
		
		String sql = "select idingresso,idtipo,idsessao,idcliente,idcadeira from ingresso ";	
		PreparedStatement stmt = con.prepareStatement(sql);		
		//ResultSet, vai abrir uma grid com os resultados do select
		ResultSet rs = stmt.executeQuery();
		
	    Ingresso i = null;
	    ArrayList<Ingresso> ingressos = new ArrayList<Ingresso>();
	    
		while (rs.next()){
	    
		    i = new Ingresso();
			i.setId(rs.getInt("idingresso"));
			
			//Buscando cadeira
			Cadeira cad = new Cadeira();
			cad.setId(rs.getInt("idcadeira"));
			
			CadeiraDao cDao = new CadeiraDao();
			Cadeira cade = new Cadeira();
			cade = cDao.getCadeira(cad.getId());
			i.setCadeira(cade);
			
			//Buscando cliente
			Cliente cli = new Cliente();
			ClienteDao cliDao = new ClienteDao();
			
			cli.setId(rs.getInt("idcliente"));
			Cliente cl=new Cliente();
			cl = cliDao.getCliente(cli.getId());			
			i.setCliente(cl);
						
			//Buscando sessao
			Sessao ses = new Sessao();
			SessaoDao sesDao = new SessaoDao();
			ses.setId(rs.getInt("idsessao"));
			Sessao se = new Sessao();
			se = sesDao.getSessao(ses.getId());
			i.setSessao(se);

			//Buscando sessao tipo
			Tipo tip = new Tipo();
			TipoDao tipDao = new TipoDao();
			tip.setId(rs.getInt("idtipo"));
			Tipo ti = new Tipo();
			ti = tipDao.getTipo(tip.getId());
			i.setTipo(ti);
		
			ingressos.add(i);
		} 
		rs.close();
		stmt.close();
		con.close();
		return ingressos;
		
		}
	
	

}
