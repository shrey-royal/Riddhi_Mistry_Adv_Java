package servletBasics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.print("<html><head><title>HTTP Servlet</title><style>body {background-color: orangered; color: yellow;}</style></head><body>");
		out.print("<h1>HTTP Servlet</h1>");
		out.print("</body></html>");
	}
}
