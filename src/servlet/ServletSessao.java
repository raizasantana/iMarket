package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ConverteData;

import model.Filme;
import model.Sala;
import model.Sessao;
import dao.FilmeDao;
import dao.SalaDao;
import dao.SessaoDao;


public class ServletSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSessao() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equals("iniciar")){
			this.iniciar(request, response);
		} else		
		if (acao.equals("Registrar")){
			this.adicionar(request, response);
		}else
		
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
	SessaoDao sessaoDao = new SessaoDao();
		
		ArrayList<Sessao> sessaos = null;
		try {
			
			sessaos=sessaoDao.getSessoes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("sessaos", sessaos);
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
        
        FilmeDao filmeDao = new FilmeDao();
		
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes("");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("filmes", filmes);
		
		
		
		
		
		int idfilme = Integer.valueOf(request.getParameter("idfilme"));
	
		SessaoDao sessaoDao = new SessaoDao();
		
		ArrayList<Sessao> sessaos = null;
		try {
			
			sessaos=sessaoDao.getSessoesFilme(idfilme);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	

		request.setAttribute("sessaos", sessaos);
		RequestDispatcher rd = request.getRequestDispatcher("/html/sessaolista.jsp");
		


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
	    Date data = null;
	    String horaIni = null;
		Sala sala = new Sala();
		SalaDao sDao=new SalaDao();
		Filme filme = new Filme();			
		FilmeDao fDao = new FilmeDao();
		
	
			try {
				data = ConverteData.strToDate(request.getParameter("data"))	;
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		
		
		horaIni = request.getParameter("horaIni");
		
		
		
			
		
			
		
			try {
				filme = fDao.getFilme(Integer.valueOf(request.getParameter("idFilme")));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
			try {
				sala = sDao.getSala(Integer.valueOf(request.getParameter("idSala")));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
	
		
		Sessao sessao = new Sessao();
		sessao.setData(data);
		sessao.setHoraIni(horaIni);
		sessao.setFilme(filme);
		sessao.setSala(sala);	
		
		SessaoDao sessaoDao = new SessaoDao();
		try {
			sessaoDao.adicionarSessao(sessao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void iniciar(HttpServletRequest request, HttpServletResponse response) {
		
		FilmeDao filmeDao = new FilmeDao();		
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes("");
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	
		
		SalaDao salaDao = new SalaDao();	
		ArrayList<Sala> salas = null;	
	
		try {
			salas = salaDao.getSalas("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		request.setAttribute("salas",salas);
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



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 this.doGet(request, response);
	}

}
