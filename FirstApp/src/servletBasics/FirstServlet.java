package servletBasics;

import java.io.*;
import javax.servlet.*;

public class FirstServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<html><head><title>Generic Servlet</title></head><body>");
		out.print("<h1>First Servlet</h1>");
		out.print("Welcome, " + req.getParameter("username"));
		out.print("</body></html>");
	}
}
