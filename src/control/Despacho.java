package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Despacho extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public static void mostrarTela(HttpServletRequest request, HttpServletResponse response){
		
		String nextPage = request.getParameter("destino");
		if (nextPage==null){
			nextPage=(String) request.getAttribute("destino");
		}
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
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
