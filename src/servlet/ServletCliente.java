package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Despacho;

import dao.ClienteDao;

import model.Cliente;



public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		
		if (acao.equals("adicionar")){
			this.adicionar(request, response);
		}
		else
		if (acao.equals("remover")){
			this.remover(request, response);
		}
		else
		if ((acao.equals("alterar"))){
			this.pegaDadosCliente(request,response);
		}
		else
			if ((acao.equals("atualizar"))){
				this.alterar(request,response);
			}
			else
		if (acao.equals("buscarum")){
			this.buscarUm(request, response);
		}
		else
		if (acao.equals("listar")){
			this.listar(request, response);
		}
		else
		if (acao.equals("listarcombo")){
			this.listarcombo(request, response);
		}
	}

	private void pegaDadosCliente(HttpServletRequest request,
			HttpServletResponse response) {
		//pegando dados do cliente registrado no banco pelo cpf
		ClienteDao cDao = new ClienteDao();
		String cpf = request.getParameter("cpf");
		Cliente cliente = null;	
	
		try {
			cliente = cDao.getCliente(cpf);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("cliente", cliente);
		request.setAttribute("destino", "/html/frmcliente.jsp");
     	Despacho.mostrarTela(request, response);
	}


	private void listarcombo(HttpServletRequest request,
			HttpServletResponse response) {
		ClienteDao cdao=new ClienteDao();
		ArrayList<Cliente> clientes=null;
		try {
			clientes=cdao.getClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd=request.getRequestDispatcher(request.getParameter("destino"));
		try {
			rd.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) {
		ClienteDao cDao = new ClienteDao();
		String nome = request.getParameter("nome");
		ArrayList<Cliente> clientes = null;	
	
		try {
			clientes = cDao.getClientes(nome);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("/html/adm/clientelista.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		ClienteDao cDao = new ClienteDao();
		String cpf = request.getParameter("cpf");
		Cliente cliente = null;	
	
		try {
			cliente = cDao.getCliente(cpf);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("cliente", cliente);
		
     	Despacho.mostrarTela(request, response);
		
	}


	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {
		String nome, cpf, email,login,senha;
		int id;
		
		id = Integer.valueOf(request.getParameter("id"));
		nome = request.getParameter("nome2");
		cpf = request.getParameter("cpf2");
		email = request.getParameter("email2");
		login = request.getParameter("login2");
		senha = request.getParameter("senha2");
		
		Cliente c = new Cliente();
		ClienteDao cDao = new ClienteDao();
		
		c.setId(id);
		c.setNome(nome);
		c.setCpf(cpf);
		c.setEmail(email);
		c.setLogin(login);
		c.setSenha(senha);
		
		
		try {
			cDao.alterarCliente(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("cliente",c);
		request.setAttribute("destino","/html/vercliente.jsp");
		
		Despacho.mostrarTela(request, response);
	}


	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
		int idcliente = Integer.valueOf(request.getParameter("idcliente"));
		
		ClienteDao cDao = new ClienteDao();
		
		try {
			cDao.apagarCliente(idcliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("destino","/html/removecliente.jsp");
		Despacho.mostrarTela(request, response);
		
	}


	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		String nome="", cpf="", email="";
		
		
		nome=request.getParameter("nome");
		cpf=request.getParameter("cpf");
		email=request.getParameter("email");
	
		
		Cliente cliente=new Cliente();
		cliente.setCpf(cpf);
		cliente.setEmail(email);		
		cliente.setNome(nome);
		
		ClienteDao cdao=new ClienteDao();
		try {
			cdao.adicionarCliente(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
