package session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sessao;

public class SessionSessao  extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private static HttpSession session;
    
	public SessionSessao(HttpServletRequest request, HttpServletResponse response) {
		super();
		session=request.getSession();
	}
	public static void setSessao(Sessao sessao){
		session.setAttribute("sessao", sessao);
	}
	public static Sessao getSessao(){
		return (Sessao) session.getAttribute("sessao");
	}
	

}
