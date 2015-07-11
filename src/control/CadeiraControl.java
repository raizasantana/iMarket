package control;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Cadeira;
import model.Sala;
import model.Sessao;
import dao.CadeiraDao;
import dao.SalaDao;
import dao.SessaoDao;


public class CadeiraControl extends HttpServlet implements IControl{


	private static final long serialVersionUID = 1L;

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) {
		String acao = request.getParameter("acao");
		if (acao.equals("lancar")) { 	
			this.listarstatus(request, response);
		} else if (acao.equals("adicionar")) {
			this.adicionar(request, response);
		} else if (acao.equals("buscarum")) {
			this.buscarUm(request, response);
		}else if (acao.equals("listarstatus")) {
			this.listarstatus(request, response);
		}
		
	}
	

	private void listarstatus(HttpServletRequest request, HttpServletResponse response) {

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

		CadeiraDao cdao=new CadeiraDao();
				
				ArrayList<Cadeira> cadeiraslivre=null;

				try {
					cadeiraslivre=cdao.getDisponiveis(sessao);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
                CadeiraDao cdao1=new CadeiraDao();
				
				ArrayList<Cadeira> cadeiras=null;

				try {
					cadeiras=cdao1.getCadeirasSala(sessao.getSala().getId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for (int i=0;i<cadeiras.size();i++){
					for (int j=0;j<cadeiraslivre.size();j++){
						if ((cadeiraslivre.get(j).getStatus()==1)&&(cadeiras.get(i).getId()==cadeiraslivre.get(j).getId())){
						
							cadeiras.set(i, cadeiraslivre.get(j));
						
						
						}
					}
					
					
				}
		
				
				
			request.setAttribute("cadeiras", cadeiras);			
			Despacho.mostrarTela(request, response);
		
	}

	/*@SuppressWarnings("unused")
	private void listar(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session;
		session=request.getSession();
		
		Sessao sessao=(Sessao) session.getAttribute("sessao");
		
		CadeiraDao cdao=new CadeiraDao();
				
				ArrayList<Cadeira> cadeiras=null;

				try {
					cadeiras=cdao.getDisponiveis(sessao);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			request.setAttribute("cadeiras", cadeiras);
			Despacho.mostrarTela(request, response);
		
	}*/

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		
		Cadeira cadeira=new Cadeira();
		
		
		
		int numero=Integer.valueOf(request.getParameter("numero"));
		
		cadeira.setNome(request.getParameter("nome"));
		cadeira.setNumero(numero);
		
		SalaDao sdao=new SalaDao();
		Sala sala=null;
		try {
			sala=sdao.getSala(Integer.valueOf(request.getParameter("idsala")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadeira.setSala(sala);
		String auto=request.getParameter("auto");
		CadeiraDao cdao=new CadeiraDao();
		
		if (auto!=null){
			
			try {
				cdao.adicionarTodas(sala.getId(), cadeira.getNome(), numero,sala.getQtdCadeiras()-numero);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		else{
		
	
		
	
		
		try {
			cdao.adicionarCadeira(cadeira);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
