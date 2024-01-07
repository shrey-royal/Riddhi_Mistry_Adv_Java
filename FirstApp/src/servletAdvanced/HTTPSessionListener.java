package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HTTPSessionListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String n = req.getParameter("name");
		out.print("Welcome, " + n);
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", n);
		
		ServletContext context = getServletContext();
		int t = (Integer)context.getAttribute("totalUsers");
		int c = (Integer)context.getAttribute("currentUsers");
		
		out.print("<br>Total Users: " + t);
		out.print("<br>Current Users: " + c);
		
		out.print("<br> <a href='HttpSessionLogout'>logout</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
