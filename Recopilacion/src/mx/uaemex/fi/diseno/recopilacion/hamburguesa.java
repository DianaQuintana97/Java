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

/**
 * Servlet implementation class Hamburguesa
 * Diana Quintana Gamboa
 */
@WebServlet("/hamburguesa")
public class hamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private int intentos=1;

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
		String cadena=request.getParameter("algo");
		int numero = Integer.parseInt(cadena);        
        
        Cookie[] pak = request.getCookies();
		if(pak!=null) {
			for(Cookie g : pak) {
				if(g.getName().equals("numero")) {
				String numString= g.getValue();
				randomNum= Integer.parseInt(numString);
				}else if (g.getName().equals("intentos")) {
					intentos = Integer.parseInt(g.getValue())+1;
					Cookie cuentaCookie = new Cookie("intentos",intentos+"");
					response.addCookie(cuentaCookie);
				}
			}
			
		}else {
			randomNum = rand.nextInt(100 )+1;
			intentos=1;
			Cookie galleta = new Cookie("numero", randomNum+"");
			response.addCookie(galleta);
			Cookie cuentaCookie=new Cookie("intentos", intentos+"");
	        response.addCookie(cuentaCookie);
			//response.getWriter().append(request.getContextPath());
			
		}
		if (numero>randomNum) {
			
            response.getWriter().append(randomNum+"Es menor ");

        }else if (numero<randomNum){

            response.getWriter().append(randomNum+"Es mayor");

        }else if (numero==randomNum) {

            response.getWriter().append(randomNum+"Ganaste con solo "+intentos+ " intentos");
            randomNum = rand.nextInt(100 )+1;
            intentos=0;
            Cookie galleta = new Cookie("numero", randomNum+"");
			response.addCookie(galleta);
			Cookie cuentaCookie=new Cookie("intentos", intentos+"");
	        response.addCookie(cuentaCookie);
        }		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		Cookie galleta = new Cookie("numero", randomNum+"");
		resp.addCookie(galleta);
		//response.getWriter().append(request.getContextPath());
		
		
        Cookie cuentaCookie=new Cookie("intentos", intentos+"");
        resp.addCookie(cuentaCookie);
	}
	

}