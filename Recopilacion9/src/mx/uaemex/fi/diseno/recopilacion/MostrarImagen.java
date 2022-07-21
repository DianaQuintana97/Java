package mx.uaemex.fi.diseno.recopilacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Integrantes:
 * Lorena Gómez Díaz
 * Monica Aidde Salinas Cuevas
 * Alejandra Marlen Rocha Aguilar
 * Diana Quintana Gamboa
 * Ismael Alcalá Pérez
 */

@WebServlet(
		description = "Mostrar imagenes", 
		urlPatterns = { "/MostrarImagen" }, 
		initParams = { 
				@WebInitParam(name = "img1", value = "img/audifonos.jpg", description = "imagen1"), 
				@WebInitParam(name = "img2", value = "img/auto.jpg", description = "imagen2"), 
				@WebInitParam(name = "img3", value = "img/balon.jpg", description = "imagen3"), 
				@WebInitParam(name = "img4", value = "img/bicicleta.jpg", description = "imagen4"), 
				@WebInitParam(name = "img5", value = "img/camara.jpg", description = "imagen5"), 
				@WebInitParam(name = "img6", value = "img/celular.jpg", description = "imagen6"), 
				@WebInitParam(name = "img7", value = "img/compu.jpg", description = "imagen7"), 
				@WebInitParam(name = "img8", value = "img/playera.jpg", description = "imagen8"), 
				@WebInitParam(name = "img9", value = "img/impresora.jpg", description = "imagen9"),
				@WebInitParam(name = "maximo", value = "9", description = "Numero maximo de imagenes a mostrar")
		})
public class MostrarImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String im1;
	private String im2;
	private String im3;
	private String im4;
	private String im5;
	private String im6;
	private String im7;
	private String im8;
	private String im9;
	private int numMax;
	private int numAleatorio;
	private int numGanador;
	
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.im1 = config.getInitParameter("img1");
		this.im2 = config.getInitParameter("img2");
		this.im3 = config.getInitParameter("img3");
		this.im4 = config.getInitParameter("img4");
		this.im5 = config.getInitParameter("img5");
		this.im6 = config.getInitParameter("img6");
		this.im7 = config.getInitParameter("img7");
		this.im8 = config.getInitParameter("img8");
		this.im9 = config.getInitParameter("img9");
		this.numMax = Integer.parseInt(config.getInitParameter("maximo"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.numAleatorio = (int) (Math.random()*this.numMax+1);
		
		String [] imagenes = {im1,im2,im3,im4,im5,im6,im7,im8,im9};
		// Se crea una lista del arreglo imagenes para despues usar el método shuffle y desordenar el arreglo
		List<String> intList = Arrays.asList(imagenes);
		Collections.shuffle(intList);
		intList.toArray(imagenes);
		this.numGanador = (int) (Math.random()*this.numAleatorio+1);
		
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		salida.println("<!DOCTYPE html>");
		salida.println("<html>");
			salida.println("<head>");
			salida.println("<title>Imagenes</title>");
			salida.println("<link href=\"css/styles.css\" rel=\"stylesheet\">");
			salida.println("</head>");
			salida.println("<body>");
				salida.println("<h1 class=\"titulo\">");
				salida.println("¡¡¡PREMIO GANADOR!!!");
				salida.println("</h1>");

				salida.println("<div class=\"contenedor\">");
					salida.println("<div class=\"contImagenes\">");
							for(int i=0; i<this.numAleatorio; i++) {
								if((this.numGanador -1) == i) {
									salida.println("<div class=\"imagen premioGanador\" >");
										salida.println("<img src=\""+imagenes[i]+"\">");
									salida.println("</div>");
								}else {
									salida.println("<div class=\"imagen\" >");
										salida.println("<img src=\""+imagenes[i]+"\">");
									salida.println("</div>");
								}
								
							}
					salida.println("</div>");
				salida.println("</div>");
			salida.println("</body>");
		salida.println("</html>");
		
	}

}
