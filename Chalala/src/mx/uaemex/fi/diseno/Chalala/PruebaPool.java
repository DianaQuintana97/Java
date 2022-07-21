package mx.uaemex.fi.diseno.Chalala;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PruebaPool
 */
@WebServlet("/PruebaPool")
public class PruebaPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected DataSource ds;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			//
			InitialContext cxt = new InitialContext();
			ds=(DataSource) cxt.lookup("java:/comp/env/jdbc/ds");
			if (ds == null) {
				throw new ServletException("No encontro la fuente de los datos");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int usuario;
		String descripcion;
		String nom;
		PrintWriter salida= response.getWriter();
		try {
			Connection con=ds.getConnection();
			Statement sentencia= con.createStatement();
			ResultSet res = sentencia.executeQuery("select * from usuario");
			while (res.next()) {
				usuario=res.getInt("id");
				descripcion=res.getString("descripcion");
				salida.append("<li>"+usuario+" "+descripcion+"</li>");
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//response.getWriter().append(this.ds.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
