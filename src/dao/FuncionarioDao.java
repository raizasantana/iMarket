package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Funcionario;

public class FuncionarioDao {

public Connection con;
	
	public  FuncionarioDao() {
			con = ConnectionFactory.getConexao();
	}
	
	public void adicionarFuncionario(Funcionario f) throws SQLException{
		
		con = ConnectionFactory.getConexao();
		
		String sql = "insert into funcionario(nome,matricula,login,senha) values(?,?,?,?) ";
		
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1,f.getNome());
		stmt.setString(2,f.getMatricula());
		stmt.setString(3,f.getLogin());
		stmt.setString(4,f.getSenha());
		
		stmt.execute();
		
		stmt.close();
		
		con.close();
		
	}
	
	public Funcionario getFuncionario(String matricula) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idfuncionario,nome,matricula,login,senha from funcionario where matricula = ?" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,matricula);
		
		ResultSet rs = stmt.executeQuery();
		
		Funcionario f = null;
		if (rs.next()){
			f = new Funcionario();
			f.setId(rs.getInt("idfuncionario"));
			f.setNome(rs.getString("nome"));
			f.setMatricula(rs.getString("matricula"));
			f.setLogin(rs.getString("login"));
			f.setSenha(rs.getString("senha"));
		}
		rs.close();
		stmt.close();
		con.close();
		
		return f;
		
	}
	
	public Funcionario getFuncionario(String login,String senha) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idfuncionario,nome,matricula,login,senha from cliente where login = ? and senha = ?" ;
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,login);
		stmt.setString(2,senha);
		
		ResultSet rs = stmt.executeQuery();
		
		Funcionario f = null;
		if (rs.next()){
			f = new Funcionario();
			f.setId(rs.getInt("idfuncionario"));
			f.setNome(rs.getString("nome"));
			f.setMatricula(rs.getString("matricula"));
			f.setLogin(rs.getString("login"));
			f.setSenha(rs.getString("senha"));
			
		}
		rs.close();
		stmt.close();
		con.close();
		
		return f;
		
	}
	
	public ArrayList<Funcionario> getFuncionarios(String nome) throws SQLException{
		con = ConnectionFactory.getConexao();
		
		String sql = "select idfuncionario,nome,matricula,login,senha from funcionario where nome like ? ";
	     	nome = "%"+ nome + "%";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		
		ResultSet rs = stmt.executeQuery();
		
		Funcionario f = null;
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		while (rs.next()){
			f = new Funcionario();
			f.setId(rs.getInt("idfuncionario"));
			f.setNome(rs.getString("nome"));
			f.setMatricula(rs.getString("matricula"));
			f.setLogin(rs.getString("login"));
			f.setSenha(rs.getString("senha"));
			
			funcionarios.add(f);
		}
		rs.close();
		stmt.close();
		con.close();
		
		return funcionarios;
		
		
	}
	
	
}//classe
