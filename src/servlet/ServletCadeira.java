package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadeira;
import model.Sala;
import model.Sessao;

import dao.CadeiraDao;
import dao.SalaDao;
import dao.SessaoDao;


public class ServletCadeira extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletCadeira() {
        super();
       
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
		if (acao.equals("alterar")){
			this.alterar(request, response);
		}
		else
		if (acao.equals("selecionarFilme")){
			this.selecionarFilme(request, response);
		}
		else
		if (acao.equals("listar")){
			this.listar(request, response);
		}
		else
		if (acao.equals("listarcombos")){
			this.listarcombos(request, response);
			}
	}

	private void listarcombos(HttpServletRequest request,
			HttpServletResponse response) {
		
		SalaDao salaDao = new SalaDao();	
		ArrayList<Sala> salas = null;	
	
		try {
			salas = salaDao.getSalas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    SessaoDao sessaoDao = new SessaoDao();		
		ArrayList<Sessao> sessaos = null;
		try {
			
			sessaos=sessaoDao.getSessoes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("sessaos", sessaos);
				
		request.setAttribute("salas",salas);
		RequestDispatcher rd = request.getRequestDispatcher(request.getParameter("destino"));
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

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
	
		
	

		
	}

	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void selecionarFilme(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		SalaDao salaDao = new SalaDao();	
		ArrayList<Sala> salas = null;	
	
		try {
			salas = salaDao.getSalas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		request.setAttribute("salas",salas);
		
		
		ArrayList<Cadeira> cadeiras=null;
		CadeiraDao caddao=new CadeiraDao();
		try {
			cadeiras=caddao.getCadeirasSala(Integer.valueOf(request.getParameter("idSala")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("cadeiras", cadeiras);
		RequestDispatcher rd=  request.getRequestDispatcher("/html/adm/cadeiralista.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
