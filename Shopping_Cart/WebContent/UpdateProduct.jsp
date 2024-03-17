<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add New Product</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<style>
  body {
    background-color: #f0f0f0;
  }
  form {
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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
  <h1 class="center-align">Update Product</h1>
  <div class="row">
    <form class="col s12" action="update" method="POST">
    <input name="id" type="hidden" value="${product.id}">
      <div class="row">
        <div class="input-field col s12">
          <input id="name" type="text" name="name" class="validate" value="${product.name}">
          <label for="name">Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <textarea id="desc" class="materialize-textarea" name="desc">${product.desc}</textarea>
          <label for="desc">Description</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="price" type="number" name="price" class="validate" value="${product.price}">
          <label for="price">Price</label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
          <button class="btn waves-effect waves-light" type="submit" name="action">Update Product</button>
        </div>
      </div>
    </form>
  </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
