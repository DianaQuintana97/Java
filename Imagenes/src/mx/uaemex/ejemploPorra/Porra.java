package mx.uaemex.ejemploPorra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Porra
 */
@WebServlet(
		description = "Porra UNAM", 
		urlPatterns = { "/Porra" }, 
		initParams = { 
				@WebInitParam(name = "pal_1", value = "Goooooya", description = "uno"), 
				@WebInitParam(name = "pal_2", value = "cachun", description = "dos"), 
				@WebInitParam(name = "pal_3", value = "rra", description = "tres"), 
				@WebInitParam(name = "repeticiones", value = "2", description = "num de veces que se repite")
		})
public class Porra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String est_1;
    private String est_2;
    private String est_3;
    private int itera;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Porra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config); 
		this.est_1=config.getInitParameter("pal_1");
		this.est_2=config.getInitParameter("pal_2");
		this.est_3=config.getInitParameter("pal_3");
		this.itera=Integer.parseInt(config.getInitParameter("repeticiones"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter salida = response.getWriter();
        salida.println("<!DOCTYPE html>");
        salida.println("<html>");
        salida.println("<head>");
        salida.println("<link rel=\"stylesheet\" href=\"css/estilos.css\">");
        salida.println("<title>PORRA</title>");
        salida.println("</head>");
        salida.println("<body>");
        
        salida.println("<h1>");
        for(int i=0;i<this.itera;i++) {
            salida.print(this.est_1+" ");
        }
        salida.println("</h1>");
        
        for(int j=0;j<this.itera;j++) {
            salida.println("<h3>");
            for(int i=0;i<this.itera;i++) {
                salida.print(this.est_2+" ");
            }
            salida.println("</h3>");
            salida.println("<h3>");
            for(int i=0;i<this.itera;i++) {
                salida.print(this.est_3+" ");
            }
            salida.println("</h3>");
        }
        salida.println("<h2>"+this.est_1+"</h2>");
        salida.println("<h1>¡¡¡¡ U N I V E R S I D A D !!!!</h1>");
        salida.println("</body>");
        salida.println("</html>");
	}

}
