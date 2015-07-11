



package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;



public class ClienteDao {
	
	public Connection con;
	
	public ClienteDao(){
		con = ConnectionFactory.getConexao();
	}
	
	public void adicionarCliente(Cliente c) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		String sql = "insert into cliente(nome,cpf,email,login,senha) values(?,?,?,?,?) ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		

		stmt.setString(1,c.getNome());
		stmt.setString(2,c.getCpf());
		stmt.setString(3,c.getEmail());
		stmt.setString(4, c.getLogin());
		stmt.setString(5, c.getSenha());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}

	

	
	public void alterarCliente(Cliente c) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		//cliente(idcliente,nome,cpf,email
		String sql = " update cliente set nome = ?, cpf = ?, email = ? ,login=? ,senha=? where idcliente = ? ";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,c.getNome());
		stmt.setString(2,c.getCpf());
		stmt.setString(3,c.getEmail());
		stmt.setString(4,c.getLogin());
		stmt.setString(5,c.getSenha());
		stmt.setInt(6,c.getId());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	public void apagarCliente(int id) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		String sql = "delete from cliente where idcliente = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,id);
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	public Cliente getCliente(String cpf) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idcliente,nome,cpf,email,login,senha from cliente where cpf = ?" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,cpf);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c = null;
		if (rs.next()){
			c = new Cliente();
			c.setId(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			c.setLogin(rs.getString("login"));
			c.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		return c;
		
	}
	
	
	
	
	public Cliente getCliente(String login,String senha) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idcliente,nome,cpf,email,login,senha from cliente where login = ? and senha = ?" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,login);
		stmt.setString(2,senha);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c = null;
		if (rs.next()){
			c = new Cliente();
			c.setId(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			c.setLogin(rs.getString("login"));
			c.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		return c;
		
	}
	
	
	
	
	
	
	public Cliente getCliente(int idcliente) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idcliente,nome,cpf,email from cliente where idcliente = ?" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,idcliente);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c = null;
		if (rs.next()){
			c = new Cliente();
			c.setId(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		return c;
		
	}
	
	public ArrayList<Cliente> getClientes() throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idcliente,nome,cpf,email from cliente" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		while (rs.next()){
			c = new Cliente();
			c.setId(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			
			clientes.add(c);
		}
		rs.close();
		stmt.close();
		con.close();
		
		return clientes;
		
		
	}
	
	

	public ArrayList<Cliente> getClientes(String nome) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idcliente,nome,cpf,email from cliente where nome like ? ";
	     	nome = "%"+nome + "%";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		while (rs.next()){
			c = new Cliente();
			c.setId(rs.getInt("idcliente"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			
			clientes.add(c);
		}
		rs.close();
		stmt.close();
		con.close();
		
		return clientes;
		
		
	}
		
		
		
		
	}


