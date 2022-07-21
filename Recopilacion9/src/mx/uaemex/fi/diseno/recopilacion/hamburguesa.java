package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hamburguesa
 * Diana Quintana Gamboa
 */
@WebServlet("/hamburguesa")
public class hamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private int intentos=0;

	 private int randomNum;

	 private Random rand = new Random();
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 public void init(ServletConfig config) throws ServletException {

	 super.init(config);//lo registra en el contenedor asegurarase que se registre en el contenedor

	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        Cookie[] pak = request.getCookies(); 
        HttpSession ses;
        ses = request.getSession();
        
        Integer hComidas=(Integer)ses.getAttribute("hComidas");//nombre y debuelve objeto
        Integer hIntentos=(Integer)ses.getAttribute("intentos");
        //primera vez jugando 
        if(hComidas==null) {
        	hComidas=rand.nextInt(100 )+1;
        	intentos=0;
        	ses.setAttribute("hComidas", hComidas);
        	ses.setAttribute("intentos ", intentos);
        }
		//si ya existe implica que no es la primera vez
        int num1=Integer.parseInt(request.getParameter("algo"));
        intentos++;
		ses.setAttribute("intentos", intentos);
		if (num1>hComidas) {
			
            response.getWriter().append(hComidas+"Es menor ");

        }else if (num1<hComidas){

            response.getWriter().append(hComidas+"Es mayor");

        }else if (num1==hComidas) {

            response.getWriter().append(hComidas+"Ganaste con solo "+intentos+ " intentos");
            hComidas = rand.nextInt(100 )+1;
            intentos=0;
            ses.setAttribute("hComidas", hComidas);
            ses.setAttribute("intentos ", intentos);
          
        }		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
