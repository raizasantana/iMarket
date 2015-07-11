			package control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarrinhoIngresso extends HttpServlet implements IControl{

	 
	
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
		}}

	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		
	}


}
