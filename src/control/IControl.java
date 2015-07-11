package control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IControl {

	public void executar(HttpServletRequest request,HttpServletResponse response);
}
