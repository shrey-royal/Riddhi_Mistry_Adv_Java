package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.util.DbConn;

public class ProductDao {
	private Connection conn = null;
	
	public void insertProduct(ProductBean product) {
		try {
			String insertQuery = "INSERT INTO products (id, name, description, price) VALUES (0, ?, ?, ?)";
			conn = DbConn.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getDesc());
			pstmt.setDouble(3, product.getPrice());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("Data Inserted Successfully!");
			} else {
				System.out.println("Failed to insert Data!");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductBean> listAll() {
		try {
			String listQuery = "SELECT * FROM products";
			conn = DbConn.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(listQuery);
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			while(rs.next()) {
				ProductBean product = new ProductBean();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDesc(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			conn.close();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ProductBean getProductById(int id) {
		try {
			String selectQuery = "SELECT * FROM products WHERE id = ?";
			conn = DbConn.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ProductBean product = new ProductBean();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDesc(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void deleteProduct(int id) {
		try {
			
			String deleteQuery = "DELETE FROM products WHERE id = ?";
			conn = DbConn.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Product Deleted Successfully");
			} else {
				System.out.println("Failed to delete product");
			}
			pstmt.close();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(ProductBean productBean) {
		try {
			String updateQuery = "UPDATE products SET name=?, description=?, price=? WHERE id=?";
			conn = DbConn.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, productBean.getName());
			pstmt.setString(2, productBean.getDesc());
			pstmt.setDouble(3, productBean.getPrice());
			pstmt.setInt(4, productBean.getId());
			
			if(pstmt.executeUpdate() == 1) {
				System.out.println("Product Details Updated Successfully!");
			} else {
				System.out.println("Failed to Update Product Details!");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
