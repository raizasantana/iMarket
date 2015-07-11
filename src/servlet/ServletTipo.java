package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tipo;
import dao.TipoDao;


public class ServletTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletTipo() {
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

	
	private void remover(HttpServletRequest request,
			HttpServletResponse response) {
		Tipo t=new Tipo();
		t.setId(Integer.valueOf(request.getParameter("idTipo")));
		TipoDao tdao=new TipoDao();
		
		try {
			tdao.apagarTipo(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		String descricao="";
		double preco=0;
		
		
		
		preco=Double.valueOf(request.getParameter("preco"));
		descricao=request.getParameter("descricao");
		
		Tipo tipo=new Tipo();
		tipo.setDescricao(descricao);		
		tipo.setPreco(preco);
		
		TipoDao tdao=new TipoDao();
		try {
			tdao.adicionarTipo(tipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void listarcombo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void alterar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) {
		TipoDao tipoDao = new TipoDao();
		String descricao = request.getParameter("descricao");
		ArrayList<Tipo> tipos = null;	
	
		try {
			tipos = tipoDao.getTipos(descricao);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("tipos", tipos);
		RequestDispatcher rd = request.getRequestDispatcher("/html/tipolista.jsp");
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
		// TODO Auto-generated method stub
	}

}
