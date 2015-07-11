package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.krb5.internal.crypto.Des;

import dao.ClienteDao;
import dao.FuncionarioDao;

import model.Cliente;
import model.Funcionario;

public class FuncionarioControl extends HttpServlet implements IControl{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) {
		String acao = request.getParameter("acao");
		if (acao.equals("adicionar")) {
			this.adicionar(request,response);
		}
		if (acao.equals("verificar")) {
			this.verificar(request,response);
		}
		if (acao.equals("logar")) {
			this.logar(request,response);
		}
		if (acao.equals("sair")) {
			this.sair(request, response);
		}
		if (acao.equals("listar")) {
			this.listar(request, response);
		}
		
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		FuncionarioDao fDao = new FuncionarioDao();
		String nome = request.getParameter("nome");
		ArrayList<Funcionario> funcionarios = null;	
	
		try {
			funcionarios = fDao.getFuncionarios(nome);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("funcionarios",funcionarios);
		request.setAttribute("destino","/html/adm/funcionariolista.jsp");
		Despacho.mostrarTela(request, response);
	}

	private void sair(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session;
		session=request.getSession();
		Funcionario fun = (Funcionario) session.getAttribute("funcionario");
		fun=null;

		session.setAttribute("funcionario", fun);

		Despacho.mostrarTela(request, response);
		
	}

	private void logar(HttpServletRequest request, HttpServletResponse response) {
		String login=request.getParameter("login");
		String senha=request.getParameter("senha");
		
		Funcionario f = null;
		FuncionarioDao fDao = new FuncionarioDao();
		
		try {
			f = fDao.getFuncionario(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session;
		session=request.getSession();

		session.setAttribute("funcionario", f);

		Despacho.mostrarTela(request, response);
	}

	private void verificar(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session;
		session=request.getSession();
	
		
		Funcionario fun=(Funcionario) session.getAttribute("funcionario");
		if (fun == null){
			request.setAttribute("destino","/html/login.jsp");
			
			Despacho.mostrarTela(request, response);
		}else
		{
			request.setAttribute("destino","/html/adm/restrito.jsp");
			this.adicionar(request, response);		
		}
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Funcionario f = new Funcionario();
		f.setNome(nome);
		f.setMatricula(matricula);
		f.setLogin(login);
		f.setSenha(senha);
		
		FuncionarioDao fDao = new FuncionarioDao();
		
		try {
			fDao.adicionarFuncionario(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Despacho.mostrarTela(request, response);
	}

	
}
