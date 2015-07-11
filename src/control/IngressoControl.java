package control;

import java.sql.SQLException;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.CadeiraDao;
import dao.IngressoDao;
import dao.SessaoDao;

import dao.TipoDao;


import model.Cadeira;
import model.Cliente;
import model.Ingresso;
import model.Sessao;

import model.Tipo;

public class IngressoControl extends HttpServlet implements IControl{

	 
	
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

		else if (acao.equals("verificar")) {
			this.verificar(request, response);
		}
		else if (acao.equals("lancar")){
			this.lancarsessao(request,response);
		}
		else if (acao.equals("lancarcadeira")){
			this.lancarcadeira(request,response);
		}
		
		
	}

	private void lancarcadeira(HttpServletRequest request,
			HttpServletResponse response) {
		int idcadeira=Integer.valueOf(request.getParameter("idcadeira"));
		
		
		CadeiraDao cdao=new CadeiraDao();
		Cadeira cadeira=null;
		try {
			cadeira=cdao.getCadeira(idcadeira);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadeira.setId(idcadeira);
		
		
		HttpSession session;
		session=request.getSession();
		
		session.setAttribute("cadeira", cadeira);
		
		TipoControl tcontrol=new TipoControl();
		tcontrol.executar(request,response);
		
		
		
	}

	private void lancarsessao(HttpServletRequest request,
			HttpServletResponse response) {
		Sessao sessao=null;
		SessaoDao sdao=new SessaoDao();
		try {
			sessao=sdao.getSessao(Integer.valueOf(request.getParameter("idsessao")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session;
		session=request.getSession();
		
		session.setAttribute("sessao", sessao);

		CadeiraControl ccontrol=new CadeiraControl();				
		ccontrol.executar(request, response);


	
		
	}

	private void verificar(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session;
		session=request.getSession();
	
		
		Cliente cliente=(Cliente) session.getAttribute("cliente");
		if (cliente == null){
			request.setAttribute("destino","/html/login.jsp");
			
			Despacho.mostrarTela(request, response);
		}else
		{
			this.adicionar(request, response);		
		}
			
		

		
	}

	private void buscarUm(HttpServletRequest request, HttpServletResponse response) {
		IngressoDao ingressoDao = new IngressoDao();
        Ingresso ingresso = null;	
	
		try {
			ingresso = ingressoDao.getIngresso(Integer.valueOf(request.getParameter("idingresso")));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		request.setAttribute("ingresso", ingresso);
		Despacho.mostrarTela(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		Ingresso ing=new Ingresso();
	
		
		
		
		
		
		
		Tipo t = null;		
		TipoDao tDao = new TipoDao();
		try {
			 t = tDao.getTipo(Integer.valueOf(request.getParameter("idtipo")));
		} catch (NumberFormatException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		ing.setTipo(t);
		
		HttpSession session;
		session=request.getSession();
		
		Cliente cli=(Cliente) session.getAttribute("cliente");
		ing.setCliente(cli);
		Cadeira cadeira=(Cadeira) session.getAttribute("cadeira");	
		ing.setCadeira(cadeira);
		Sessao sessao=(Sessao) session.getAttribute("sessao");;		
		ing.setSessao(sessao);
		
		
		
		

		
		IngressoDao ingdao=new IngressoDao();
		try {
			ingdao.adicionarIngresso(ing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   request.setAttribute("ingresso",ing);
       this.imprime(request,response);
		
		
		
	}

	private void imprime(HttpServletRequest request,
			HttpServletResponse response) {
		    Ingresso ingresso = null;	    
		
			ingresso = (Ingresso) request.getAttribute("ingresso");
		
			request.setAttribute("destino", "/html/imprimeingresso.jsp");
			request.setAttribute("ingresso", ingresso);
			Despacho.mostrarTela(request, response);
			
		
	}

}
