package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CharacterBean;
import com.dao.CharacterDao;

public class UpdateCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String characterName = req.getParameter("characterName");
		String creator = req.getParameter("creator");
		
		try {
			CharacterBean character = new CharacterBean();
			character.setId(id);
			character.setCharacterName(characterName);
			character.setCreator(creator);
			
			CharacterDao d = new CharacterDao();
			
			if(d.updateCharacter(character)) {
				System.out.println("Data Updated Successfully!");
				req.getRequestDispatcher("/view/listAllCharacters.jsp").forward(req, res);
			} else {
				System.out.println("Failed to Update Data!");
				req.getRequestDispatcher("/view/editCharacter.jsp").include(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
