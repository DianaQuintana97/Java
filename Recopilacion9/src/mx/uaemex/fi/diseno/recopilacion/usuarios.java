package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Usuarios
 *  Integrantes:
 * Lorena Gómez Díaz
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcalá Pérez
 */
@WebServlet("/usuarios")
public class usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena=request.getParameter("padre");

        int padre = Integer.parseInt(cadena);
        int hijos = 0;
        if(padre==1) {
        	 hijos = 5;
        }else if(padre==2) {
        	 hijos = 3;
        }else if(padre==3) {
        	 hijos = 2;
        }
        
        response.setContentType("text/html");
        PrintWriter salida = response.getWriter();
        salida.println("<!DOCTYPE html>");
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<title>Hijos</title>");
        salida.println("</head>");
        salida.println("<body>");
        salida.println("<form action=\"mis_hijos\" method=\"post\">");
        salida.println("<input type=\"hidden\" value=\""+hijos+"\" name=\"numHijos\"/>");
        for(int i=0; i<hijos; i++) {
        	salida.println("<div><label>Hijo:"+(i+1)+"</label><input placeholder=\"Nombre\" name=\"hijo"+i+"\"/></div><br>");	
		}
        salida.println("<input type=\"submit\" value=\"Enviar\" />");
        salida.println("</form>");
        salida.println("</body>");
        salida.println("</html>");
      
		
		
		
	}
	
	
	

}
