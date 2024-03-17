package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ProductBean productBean = new ProductBean();
		ProductDao productDao = new ProductDao();
		
		productBean = productDao.getProductById(id);
		productDao.deleteProduct(id);
		
		System.out.println("\nFollowing are the product details that will be removed: ");
		System.out.println("ID: " + productBean.getId() + "\name: " + productBean.getName() + "\nDesc: " + productBean.getDesc() + "\nPrice: " + productBean.getPrice());
		
		RequestDispatcher rd = req.getRequestDispatcher("listall");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
