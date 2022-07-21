package mx.uaemex.ejemplos;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Eco
 */
@WebServlet("/eco")
public class Eco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int intentos;
	private int randomNum;
	private Random rand = new Random(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);//lo registra en el contenedor asegurarase que se registre en el contenedor
		randomNum = rand.nextInt(100 )+1;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cadena=request.getParameter("algo");
		int numero = Integer.parseInt(cadena);
		intentos=intentos+1;
		if (numero>randomNum) {
			response.getWriter().append(randomNum+"Es mayor ");
		}else if (numero<randomNum){
			response.getWriter().append(randomNum+"Es menor");
		}else if (numero==randomNum) {
			response.getWriter().append(randomNum+"Ganaste con solo "+intentos+ " intentos");
		}
	}

}
