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
 * Servlet implementation class MisHijos
 * 
 * Integrantes:
 * Lorena Gómez Díaz
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcalá Pérez
 */
@WebServlet("/mis_hijos")
public class mis_hijos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cadena=request.getParameter("numHijos");

        int numHijos = Integer.parseInt(cadena);
     
        
        if(numHijos==5) {
        	response.getWriter().append("<h1>Hal</h1>");
       }else if(numHijos==3) {
    	   response.getWriter().append("<h1>Omero</h1>");
       }else if(numHijos==2) {
    	   response.getWriter().append("<h1>Ozai</h1>");
       }
        
        for(int i=0;i<numHijos;i++) {
        		String nomHijo=request.getParameter("hijo"+i);
        	 response.getWriter().append("Nombre: "+nomHijo+"<br>");
        }
      
      
		
		
		
	}
	
	
	

}
