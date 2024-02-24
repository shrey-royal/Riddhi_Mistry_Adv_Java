package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CharacterBean;
import com.dao.CharacterDao;

//url: insert
public class InsertCharacterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int characterId = Integer.parseInt(req.getParameter("characterId"));
		String characterName = req.getParameter("characterName");
		String creator = req.getParameter("creator");
		
		System.out.println("characterId: " + characterId + "Character Name: " + characterName + "\nCreator: " + creator);
		
		CharacterBean characterBean = new CharacterBean();
		CharacterDao characterDao = new CharacterDao();
		
		characterBean.setId(characterId);
		characterBean.setCharacterName(characterName);
		characterBean.setCreator(creator);
		
		characterDao.insertCharacter(characterBean);
		
		characterDao.getAllCharacters();
		
		//list all characters
		RequestDispatcher rd = req.getRequestDispatcher("/view/listAllCharacters.jsp");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
