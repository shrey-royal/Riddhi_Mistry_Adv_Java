<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List All Products</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <style>
        body {
            background-color: #f0f0f0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
        
        .delete-btn {
        	background-color: #ff4f4f;
        }
        
        .delete-btn:hover {
        	background-color: #ff3333;
        }
    </style>
</head>
<body>
<nav>
    <div class="nav-wrapper teal">
        <a href="#" class="brand-logo">Shopping Cart</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="insertProduct.html">Insert Product</a></li>
            <li><a href="listall">List All Products</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1 class="center-align">All Products</h1>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <!-- Fetch and display product data here -->
        <c:forEach items="${products}" var="product">
            <tr>
            	<td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.desc}</td>
                <td>${product.price}</td>
                <td>
                	<a href="update?id=${product.id}" class="btn waves-effect waves-light">Update</a>
                	<a href="delete?id=${product.id}" class="btn waves-effect waves-light delete-btn">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
