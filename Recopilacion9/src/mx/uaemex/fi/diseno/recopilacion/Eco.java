package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Eco
 * Integrantes:
 * Lorena G�mez D�az
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcal� P�rez
 */
@WebServlet("/eco")
public class Eco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cadena=request.getParameter("algo").toUpperCase();
		response.getWriter().append("Hola buenos dias ").append(cadena);
		
		
		
	}

}
