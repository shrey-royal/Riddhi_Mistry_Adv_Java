package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		double price = Double.parseDouble(req.getParameter("price"));
		
		System.out.println("Name: " + name + "\nDesc: " + desc + "\nPrice: " + price);
		
		ProductBean productBean = new ProductBean();
		ProductDao productDao = new ProductDao();
		
		productBean.setName(name);
		productBean.setDesc(desc);
		productBean.setPrice(price);
		
		productDao.insertProduct(productBean);
		
		RequestDispatcher rd = req.getRequestDispatcher("listall");
		rd.forward(req, res);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
