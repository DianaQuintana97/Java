package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hamburguesa
 * Diana Quintana Gamboa
 */
@WebServlet("/hornea")
public class Cocinero extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie galleta = new Cookie("sabor", "chocolate");
		response.addCookie(galleta);
		response.getWriter().append("Cocinando.... listo").append(request.getContextPath());
	}


}
