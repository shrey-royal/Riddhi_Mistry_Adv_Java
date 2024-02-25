package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CharacterDao;

//url: delete
public class DeleteCharacterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		if(id > 0) {
			try {
				CharacterDao character = new CharacterDao();				
				PrintWriter out = res.getWriter();
				if(character.deleteCharacterById(id)) {
					out.println("<html><body><script>alert(\"Character Deleted Successfully!\");</script></body></html>");
					req.getRequestDispatcher("/view/listAllCharacters.jsp").include(req, res);
				} else {
					out.println("<html><body><script>alert(\"Failed to delete Character\");</script></body></html>");
					req.getRequestDispatcher("/view/listAllCharacters.jsp").include(req, res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
