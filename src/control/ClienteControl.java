package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

import dao.ClienteDao;

public class ClienteControl extends HttpServlet implements IControl{

	 
	
	private static final long serialVersionUID = 1L;

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) {
		String acao = request.getParameter("acao");
		if (acao.equals("listar")) { 	
			this.listar(request, response);
		} else if (acao.equals("adicionar")) {
			this.adicionar(request, response);
		} else if (acao.equals("buscarum")) {
			this.buscarUm(request, response);
		}
		else if (acao.equals("logar")) {
			this.logar(request, response);
		}
		else if (acao.equals("sair")) {
			this.sair(request, response);
		}
		
	}
	
	private void sair(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session;
		session=request.getSession();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		cliente=null;

		session.setAttribute("cliente", cliente);

		Despacho.mostrarTela(request, response);
		
	}
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void logar(HttpServletRequest request, HttpServletResponse response) {
String login=request.getParameter("login");
String senha=request.getParameter("senha");
Cliente cliente=null;
ClienteDao clidao=new ClienteDao();
try {
	cliente=clidao.getCliente(login, senha);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


HttpSession session;
session=request.getSession();

session.setAttribute("cliente", cliente);

Despacho.mostrarTela(request, response);


		

}
	

}
