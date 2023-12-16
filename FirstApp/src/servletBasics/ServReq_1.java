package servletBasics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServReq_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
//		String name = req.getParameter("name");
		String email = req.getParameter("mail");
		String contactNo = req.getParameter("contact");
		
		out.print("<br>Name: " + req.getParameter("name"));
		out.print("<br>Email: " + email);
		out.print("<br>Contact Number: " + contactNo);
		
//		out.print("HTTP headers sent by your client: <br>");
//		
//		Enumeration<String> enumeration = req.getHeaderNames();
//		
//		while(enumeration.hasMoreElements()) {
//			String headerName = (String) enumeration.nextElement();
//			String headerValue = req.getHeader(headerName);
//			out.print("<b>" + headerName + "</b>:" + headerValue + "<br>");
//		}
//		
		
		out.close();
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}