package servletBasics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletConfig config = getServletConfig();
//		config.getInitParameter("Uname");
		Enumeration<String> e = config.getInitParameterNames();
		
		String str = "";
		while(e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br>Name: " + str);
			out.print("\tValue: " + config.getInitParameter(str));
		}
		
		out.close();
	}
	
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }

}
