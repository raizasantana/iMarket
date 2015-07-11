package view;

import java.sql.SQLException;

import dao.ClienteDao;
import model.Cliente;

public class PrincipalCliente {

	public static void main(String[] args) {
		
		Cliente cli = new Cliente();
		
		cli.setId(6);
		cli.setNome("Anny Mayara");
		cli.setCpf("123654789101");
		cli.setEmail("contato@annymayara.com");
	
		ClienteDao cliDao = new ClienteDao();
		
		try {
			cliDao.adicionarCliente(cli);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cliDao.getCliente(cli.getCpf());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nome: " + cli.getNome());
		
	
	}
}
