package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tipo;



import dao.TipoDao;

public class TipoControl extends HttpServlet implements IControl {

	/**
	 * 
	 */
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
		} else if (acao.equals("lancarcadeira")) {
			this.listar(request, response);
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		TipoDao tdao=new TipoDao();
		ArrayList<Tipo> tipos=null;
		try {
			tipos=tdao.getTipos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tipos", tipos);
		Despacho.mostrarTela(request, response);

	}

	private void adicionar(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void buscarUm(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
