package servletBasics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String password = req.getParameter("password");
		
		if(password.equals("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("first");
			rd.forward(req, res);
		} else {
			out.print("Sorry Username or Password Error!");
			req.getRequestDispatcher("/basic_forms/LoginForm1.html").include(req, res);
		}
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req, res);
    }

}
