package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Sessao;
import dao.SessaoDao;

public class SessaoControl extends HttpServlet implements IControl{

	 
	
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
		
	}



	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		int idfilme = Integer.valueOf(request.getParameter("idfilme"));
		
		SessaoDao sessaoDao = new SessaoDao();
		
		ArrayList<Sessao> sessaos = null;
		try {
			
			sessaos=sessaoDao.getSessoesFilme(idfilme);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	

		request.setAttribute("sessaos", sessaos);
		Despacho.mostrarTela(request, response);
	}

}
