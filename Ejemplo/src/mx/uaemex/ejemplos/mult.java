package mx.uaemex.ejemplos;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * Servlet implementation class mult
 */
@WebServlet("/mult")
public class mult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cadena=request.getParameter("algo");
		int numero = Integer.parseInt(cadena);
		for (int i=1; i<numero; i++) {
			if((i % 3)==0) {
				response.getWriter().append(i+"fizz \r\n");
			}else if((i % 5)==0) {
				response.getWriter().append(i+"bazz \r\n");
			}else {
				response.getWriter().append(i+"\r\n");
			}
			
		}
	}



}
