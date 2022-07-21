package uaemex.imagenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import javafx.print.Collation;

/**
 * Servlet implementation class Imagenes
 * DIANA QUINTANA GAMBOA 
 */
@WebServlet(
		description = "imagenes ejemplo", 
		urlPatterns = { "/Imagenes" }, 
		initParams = { 
				@WebInitParam(name = "im_1", value = "ima/1.jfif", description = "uno"), 
				@WebInitParam(name = "im_2", value = "ima/2.jpg", description = "dos"), 
				@WebInitParam(name = "im_3", value = "ima/3.jpg", description = "tres"), 
				@WebInitParam(name = "im_4", value = "ima/4.jfif", description = "cuatro"), 
				@WebInitParam(name = "im_5", value = "ima/5.jfif", description = "cinco"), 
				@WebInitParam(name = "im_6", value = "ima/6.jfif", description = "seis"), 
				@WebInitParam(name = "im_7", value = "ima/7.jpg", description = "siete"), 
				@WebInitParam(name = "im_8", value = "ima/8.jfif", description = "ocho"), 
				@WebInitParam(name = "im_9", value = "ima/9.jfif", description = "nueve"),
				@WebInitParam(name = "max", value = "9", description = "maximo")
		})
public class Imagenes extends HttpServlet {
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
    private Random rand = new Random(); 
    private Random r = new Random(); 
    private int randomNum;
    private int randomNum2;
    private int maxi;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagenes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.im1=getInitParameter("im_1");
		this.im2=getInitParameter("im_2");
		this.im3=getInitParameter("im_3");
		this.im4=getInitParameter("im_4");
		this.im5=getInitParameter("im_5");
		this.im6=getInitParameter("im_6");
		this.im7=getInitParameter("im_7");
		this.im8=getInitParameter("im_8");
		this.im9=getInitParameter("im_9");
		this.maxi=Integer.parseInt(getInitParameter("max"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8;image/jpeg");
        PrintWriter salida = response.getWriter();
        salida.println("<!DOCTYPE html>");
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        salida.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");
        salida.println("<title>Imagenes</title>");
        salida.println("</head>");
        salida.println("<body>");
        String [] imagAll = {im1,im2,im3,im4,im5,im6,im7,im8,im9};
       	
        for (int i=0; i<imagAll.length; i++) {
            int posAleatoria = r.nextInt(imagAll.length);
            String temp = imagAll[i];
            imagAll[i] = imagAll[posAleatoria];
            imagAll[posAleatoria] = temp;
        }
		randomNum = rand.nextInt(maxi )+1;
		salida.println("<div class=\"uno\">");
		salida.println("<div class=\"dos\">");  
		
		for (int i=0; i<randomNum; i++) {
        	salida.print("<a href=\""+imagAll[i]+"\"><img src=\""+imagAll[i]+"\"></a>");
        }
		salida.println("</div>");
        salida.println("</div>");
        salida.println("<div align=\"center\">");
		randomNum2 = rand.nextInt(randomNum);
		salida.println("<a href=\""+imagAll[randomNum2]+"\"><img src=\""+imagAll[randomNum2]+"\"  class=\"bueno\"><a>");
		salida.println("</div>");
		
		salida.println("<div style=\"text-align:center\" >");
		salida.println("<h1>");
        salida.println("Es el ganador ");
        salida.println("</h1>");
        salida.println("</div>");
        //salida.println("<img src='"+im1+"' />");
        salida.println("</body>");
        salida.println("</html>");
	}

}

