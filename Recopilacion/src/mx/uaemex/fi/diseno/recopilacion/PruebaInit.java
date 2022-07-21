package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PruebaInit
 * Integrantes:
 * Lorena Gómez Díaz
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcalá Pérez
 */
//se ejecuta una vez
@WebServlet(description = "Pruebas init", urlPatterns = { "/test" })
public class PruebaInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rand;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);//lo registra en el contenedor asegurarase que se registre en el contenedor
		this.rand = new Random(23); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(" ").append(this.rand.nextInt()+"");
	}

}
