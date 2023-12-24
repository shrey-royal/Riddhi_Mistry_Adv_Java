package servletBasics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serv_Context extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletContext context = getServletContext();
		
//		String v = context.getInitParameter("version");
//		out.println("version: " + v);
		Enumeration<String> e = context.getInitParameterNames();
		
		String str = "";
		while(e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br>Name: " + str);
			out.print("\tValue: " + context.getInitParameter(str));
		}
		
		
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
