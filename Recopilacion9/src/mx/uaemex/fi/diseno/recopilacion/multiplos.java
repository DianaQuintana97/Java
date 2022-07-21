package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hitler
 * 
 * Integrantes:
 * Lorena Gómez Díaz
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcalá Pérez
 */
@WebServlet("/multiplos")
public class multiplos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cadena=request.getParameter("algo");

		 int numero = Integer.parseInt(cadena);

		 for (int i=1; i<=numero; i++) {

		 if((i % 3)==0) {

		 response.getWriter().append(i+"fizz"+"\n");

		 }else if((i % 5)==0) {

		 response.getWriter().append(i+"bazz "+"\n");

		 }else {

		 response.getWriter().append(i+"\n");

		 }
		
		
		
	}

}
}