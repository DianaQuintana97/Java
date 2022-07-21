package mx.uaemex.fi.diseno.hamburguesa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hamburguesa 
 * Integrantes:
 * 	Lorena Gómez Díaz
 *  Monica Aidee Salinas Cuevas
 *  Diana Quintana Gamboa
 *  Edson Silva Castro
 *  Ismael Alcalá Pérez
 */
@WebServlet("/hamburguesa")
public class hamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Random rand = new Random();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 public void init(ServletConfig config) throws ServletException {

	 super.init(config);
	

	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena=request.getParameter("algo");
        int numero = Integer.parseInt(cadena);
       
       
        
        HttpSession ses;
        ses = request.getSession();
        Integer hComidas=(Integer)ses.getAttribute("hComidas");
        Integer hIntentos = (Integer) ses.getAttribute("hIntentos");
       
        if(hComidas == null) {
        	hComidas = rand.nextInt(100)+1;
        	ses.setAttribute("hComidas", hComidas);
        }
        if(hIntentos == null) {
        	hIntentos = 0;
        	ses.setAttribute("hIntentos", hIntentos);
        }
       
      
        hIntentos++;
        ses.setAttribute("hIntentos", hIntentos);
        if (numero>hComidas) {

            response.getWriter().append("<h1>El número es menor, so sorry my friend :(</h1> ");
            

        }else if (numero<hComidas){

            response.getWriter().append("<h1>El número es mayor, so sorry my friend  :(</h1>");
           

        }else if (numero==hComidas) {

            response.getWriter().append("<h1>Ganaste con solo "+hIntentos+ " intentos!!!  <3 </h1>");
            
            hComidas = rand.nextInt(100 )+1;
            ses.setAttribute("hComidas", hComidas);
            hIntentos=0;
        	ses.setAttribute("hIntentos", hIntentos);
           
           
         

        }
		
		
		
	}
	

}