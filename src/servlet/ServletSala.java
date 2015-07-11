package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sala;


import dao.SalaDao;

public class ServletSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSala() {
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
	
	private void listarcombo(HttpServletRequest request,
			HttpServletResponse response) {
		
		SalaDao salaDao = new SalaDao();	
		ArrayList<Sala> salas = null;	
	
		try {
			salas = salaDao.getSalas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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


	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		SalaDao salaDao = new SalaDao();	
		ArrayList<Sala> salas = null;	
	
		try {
			salas = salaDao.getSalas(request.getParameter("nome"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("salas",salas);
		RequestDispatcher rd = request.getRequestDispatcher("/html/adm/salalista.jsp");
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
		
		
	}


	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}


	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
	
	}


	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		Sala sala=new Sala();
		
		sala.setNome(request.getParameter("nome"));
		sala.setQtdCadeiras(Integer.valueOf(request.getParameter("qtdCadeiras")));
		sala.setQtdFileiras(Integer.valueOf(request.getParameter("qtdFileiras")));
		
		SalaDao saladao=new SalaDao();
		try {
			saladao.adicionarSala(sala);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
}

}
