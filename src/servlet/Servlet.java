package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.IControl;


public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet() {
        super();
   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String className = "control." + request.getParameter("classe");
		
		try {
			Class<?> clazz = Class.forName(className);
			IControl control = (IControl) clazz.newInstance();
			control.executar(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
