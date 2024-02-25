package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CharacterBean;
import com.dao.CharacterDao;

//url: edit
public class EditCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String characterId = req.getParameter("id");
		
		if(characterId != null && !characterId.isEmpty()) {
			try {
				int id = Integer.parseInt(characterId);
				CharacterDao dao = new CharacterDao();
				CharacterBean character = dao.getCharacterById(id);
//				System.out.println(character);
				if(character != null) {
					req.setAttribute("character", character);
					req.getRequestDispatcher("/view/editCharacter.jsp").forward(req, res);
					return;
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
	}

}
