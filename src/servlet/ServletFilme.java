package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Filme;

import dao.FilmeDao;



public class ServletFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletFilme() {
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
			if (acao.equals("listarcombo")){
				this.listarcombo(request, response);
			}
		
	}
	private void listarcombo(HttpServletRequest request,
			HttpServletResponse response) {
FilmeDao filmeDao = new FilmeDao();
		
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes("");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("filmes", filmes);
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

	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
int id = 0;
		
		try{
			id = Integer.valueOf(request.getParameter("idtxt"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}			

		
	
		Filme filme = new Filme();
		filme.setId(id);
		
				
		FilmeDao filmeDao = new FilmeDao();
		try {
			filmeDao.apagarFilme(filme);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		

		
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {


		String nome="",  sinopse="";
		String dataIni="", dataFin="";
		int duracao=0, censura=0;
		
		
		try {
			duracao=Integer.valueOf(request.getParameter("duracao"));	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		censura=Integer.valueOf(request.getParameter("censura"));
		
		
		nome=request.getParameter("nome");
		sinopse=request.getParameter("sinopse");
		dataIni=request.getParameter("dataIni");
		dataFin=request.getParameter("dataFin");
		
		Filme filme=new Filme();
	
		filme.setNome(nome);
		filme.setCensura(censura);
		filme.setSinopse(sinopse);
		filme.setDuracao(duracao);
		filme.setDataFin(dataFin);
		filme.setDataIni(dataIni);
		
		
		
		FilmeDao filmeDao = new FilmeDao();
		try {
			filmeDao.adicionarFilme(filme);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {

		String nome="",  sinopse="";
		String dataIni="", dataFin="";
		int duracao=0, censura=0;
		
		
		
	
		try {
			duracao=Integer.valueOf(request.getParameter("duracao"));	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		censura=Integer.valueOf(request.getParameter("censura"));
		
		
		nome=request.getParameter("nome");
		sinopse=request.getParameter("sinopse");
		dataIni=request.getParameter("dataIni");
		dataFin=request.getParameter("dataFin");
		
		Filme filme=new Filme();
	
		filme.setNome(nome);
		filme.setCensura(censura);
		filme.setSinopse(sinopse);
		filme.setDuracao(duracao);
		filme.setDataFin(dataFin);
		filme.setDataIni(dataIni);
		
		
		
		FilmeDao filmeDao = new FilmeDao();
		try {
			filmeDao.alterarFilme(filme);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
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
		RequestDispatcher rd = request.getRequestDispatcher("/html/filmelista.jsp");
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

	private void selecionarFilme(HttpServletRequest request,
			HttpServletResponse response) {
		FilmeDao filDao = new FilmeDao();
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		Filme fil = null;
		try {
			
			fil = filDao.getFilme(id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("filme", fil);
		RequestDispatcher rd = request.getRequestDispatcher("/html/frmsessao.jsp");
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

	

}
