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
import model.Cliente;
import model.Filme;
import model.Ingresso;
import model.Sessao;
import model.Tipo;
import dao.CadeiraDao;
import dao.ClienteDao;
import dao.FilmeDao;
import dao.IngressoDao;
import dao.SessaoDao;
import dao.TipoDao;


public class ServletIngresso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletIngresso() {
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
			if (acao.equals("iniciar")){
				this.iniciar(request, response);
			}
			else
				if (acao.equals("iniciar2")){
					this.iniciar2(request, response);
				}
				else
					if (acao.equals("iniciar3")){
						this.iniciar3(request, response);
					}
		
	}

	
	private void iniciar3(HttpServletRequest request,
			HttpServletResponse response) {
	
		
		Cliente cliente=new Cliente();
		cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
	
		
		
		SessaoDao sessaodao=new SessaoDao();
		Sessao sessao=null;
		try {
			sessao=sessaodao.getSessao(Integer.valueOf(request.getParameter("idSessao")));
		} catch (NumberFormatException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		
		
		
		CadeiraDao cdao=new CadeiraDao();
		ArrayList<Cadeira> cadeiras=null;
		try {
			cadeiras=cdao.getCadeirasSala(sessao.getSala().getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TipoDao tdao=new TipoDao();
		ArrayList<Tipo> tipos=null;
		try {
			tipos=tdao.getTipos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		request.setAttribute("tipos", tipos);
		request.setAttribute("cadeiras", cadeiras);
		request.setAttribute("sessao", sessao);
		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("/html/frmingresso2.jsp");
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


	private void iniciar2(HttpServletRequest request,
			HttpServletResponse response) {

		ClienteDao clidao = new ClienteDao();
		Cliente cliente=null;
		
		try {
			cliente= clidao.getCliente(Integer.valueOf(request.getParameter("idCliente")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

        FilmeDao filmeDao = new FilmeDao();
		
		ArrayList<Filme> filmes = null;	
	
		try {
			filmes = filmeDao.getFilmes("");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
		
		
		
	
		SessaoDao sessaoDao = new SessaoDao();
		
		ArrayList<Sessao> sessaos = null;
		try {
			
			sessaos=sessaoDao.getSessoesFilme(Integer.valueOf(request.getParameter("idFilme")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		request.setAttribute("filmes", filmes);
		request.setAttribute("cliente", cliente);		
		request.setAttribute("sessaos", sessaos);
		RequestDispatcher rd = request.getRequestDispatcher("/html/frmingresso1.jsp");
		


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


	private void iniciar(HttpServletRequest request,
			HttpServletResponse response) {
		
		ClienteDao clidao = new ClienteDao();
		Cliente cliente=null;
		
		try {
			cliente= clidao.getCliente(Integer.valueOf(request.getParameter("idCliente")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FilmeDao fdao = new FilmeDao();
		ArrayList<Filme> filmes=null;
		
		try {
			filmes= fdao.getFilmes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("cliente", cliente);
		request.setAttribute("filmes",filmes);
		
		RequestDispatcher rd=request.getRequestDispatcher("/html/frmingresso1.jsp");
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
		Ingresso ing=new Ingresso();
		
		Cadeira cadeira=null;
		CadeiraDao cdao=new CadeiraDao();
		try {
			cadeira=cdao.getCadeira(Integer.valueOf(request.getParameter("idCadeira")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ing.setCadeira(cadeira);		

		Cliente cli=null;
		ClienteDao clidao=new ClienteDao();
		try {
			cli=clidao.getCliente(Integer.valueOf(request.getParameter("idCliente")));
		} catch (NumberFormatException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ing.setCliente(cli);
		
		Tipo t=null;
		TipoDao tdao=new TipoDao();
		try {
			t=tdao.getTipo(Integer.valueOf(request.getParameter("idTipo")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ing.setTipo(t);
		
		Sessao s=null;
		SessaoDao sdao=new SessaoDao();
		try {
			s=sdao.getSessao(Integer.valueOf(request.getParameter("idSessao")));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ing.setSessao(s);
		
		
					
		
		
		
		
		
		
		IngressoDao ingdao=new IngressoDao();
		try {
			ingdao.adicionarIngresso(ing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) {
        IngressoDao ingressoDao = new IngressoDao();
        ArrayList<Ingresso> ingressos = null;	
	
		try {
			ingressos = ingressoDao.getIngressos();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("ingressos", ingressos);
		RequestDispatcher rd = request.getRequestDispatcher("/html/ingressolista.jsp");
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


	private void selecionarFilme(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
