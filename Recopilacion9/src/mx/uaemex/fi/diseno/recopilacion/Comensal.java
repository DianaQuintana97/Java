package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/Comensal")
public class Comensal extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] pak = request.getCookies();
		PrintWriter salidaPrintWriter =response.getWriter();
		if(pak!=null) {
		for(Cookie g : pak) {
			salidaPrintWriter.println("Dominio:"+g.getDomain());
			salidaPrintWriter.println("Nombre:"+g.getName());
			salidaPrintWriter.println("Valor:"+g.getValue());

		}
		}else {
			salidaPrintWriter.println("<p>No hay galletas ...</p>");
			salidaPrintWriter.println("<p>Pero puedes <a href=\"hornea\">cocinar</a> ...</p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
