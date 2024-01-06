package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		req.getRequestDispatcher("/basic_forms/links.html").include(req, res);
		
		Cookie ck[] = req.getCookies();
		if(ck != null) {
			String name = ck[0].getValue();
			if(!name.equals("") || name != null) {
				out.print("<br><b> Welcome to Profile</b>");
				out.print("<br>Welcome, " + name);
			}
		} else {
			out.print("<br><p style='color: red;'>Please Login First</p>");
			req.getRequestDispatcher("/basic_forms/login.html").include(req, res);
		}
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
