package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Filme;
import dao.FilmeDao;

public class FilmeControl extends HttpServlet implements IControl{

	 
	
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
		}if (acao.equals("listartodos")) { 	
			this.listarTodos(request, response);}
		
	}

	private void listarTodos(HttpServletRequest request,
			HttpServletResponse response) {
		FilmeDao filmeDao = new FilmeDao();
	
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("filmes", filmes);
		Despacho.mostrarTela(request, response);
		
	}

	private void buscarUm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		FilmeDao filmeDao = new FilmeDao();
		String nome = request.getParameter("nome");
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes(nome);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("filmes", filmes);
		Despacho.mostrarTela(request, response);
		
	}

}
