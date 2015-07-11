package session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;


public class SessionCliente  extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private HttpSession session;
    
	public SessionCliente(HttpServletRequest request, HttpServletResponse response) {
		super();
		session=request.getSession();
	}
	public  void setCliente(Cliente cliente){
		session.setAttribute("cliente", cliente);
	}
	public Cliente getCliente(){
		return (Cliente) session.getAttribute("cliente");
	}

}
