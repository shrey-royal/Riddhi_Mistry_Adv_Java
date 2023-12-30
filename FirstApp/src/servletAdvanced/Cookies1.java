package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		out.print("Welcome " + username);
		
		Cookie ck = new Cookie("username", username);
		res.addCookie(ck);
//		ck[1] = new Cookie("password", password);
//		res.addCookie(ck[1]);
		
		out.print("<form action='/FirstApp/Cookies2'>");
		out.print("<input type='submit' value='Cookies2'>");
		out.print("</form>");
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
