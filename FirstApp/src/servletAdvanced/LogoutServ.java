package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("/basic_forms/links.html").include(req, res);
		
		Cookie ck = new Cookie("name", "");	//before deleting any cookie make sure the value is null.
		ck.setMaxAge(0);	//Cookie will be deleted (*if the value is null or empty)
		res.addCookie(ck);
		
		out.print("<br>you are successfully logged out!");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
