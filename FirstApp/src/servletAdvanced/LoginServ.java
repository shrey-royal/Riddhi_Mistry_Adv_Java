package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	res.setContentType("text/html");
    	PrintWriter out = res.getWriter();
    	
    	req.getRequestDispatcher("/basic_forms/links.html").include(req, res);
    	
    	String name = req.getParameter("name");
    	String password = req.getParameter("password");
    	
    	if(password.equals("admin123")) {
    		out.print("<br>You are Successfully Logged in!");
    		out.print("<br> Welcome, " + name);
    		
    		Cookie ck = new Cookie("name", name);
    		res.addCookie(ck);
    	} else {
    		out.print("<br><p style='color: red;'>sorry, username or password error!</p>");
    		req.getRequestDispatcher("login.html").include(req, res);
    	}
    	out.close();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }

}
