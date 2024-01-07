package servletAdvanced;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener {
	
	ServletContext context = null;
	static int total = 0, current = 0;
	
    public void sessionCreated(HttpSessionEvent se)  { 
         total++;
         current++;
         
         context = se.getSession().getServletContext();
         context.setAttribute("totalUsers", total);
         context.setAttribute("currentUsers", current);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         current--;
         
         context.setAttribute("currentUsers", current);
    }
	
}
