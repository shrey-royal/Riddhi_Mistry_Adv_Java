package servletAdvanced;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HTTPSession2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(false);
		/* Resuming the session created in the previous servlet using the same method that was used to the session. The boolean parameter 'false' has been passed so that a new session is not created since the session already exists.
		*/
		
		String n = (String)session.getAttribute("uname");
		out.print("<br>Hello " + n);
		out.print("<br>CreationTime -> " + session.getCreationTime());
		out.print("<br>ID -> " + session.getId());
//		session.invalidate();
		out.print("<br>getLastAccessedTime -> " + session.getLastAccessedTime());
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
