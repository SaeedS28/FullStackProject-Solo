<%@page import="com.fdmgroup.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>${itemInfo.name}</title>
</head>
<body>
	<jsp:include page="NavBarAdmin.jsp" />
<% User loggedIn = (User)session.getAttribute("user"); %>
	<div class="information" align="center" style="margin-top: 5%; max-width:500px; margin-left:34%">
		<h1>${itemInfo.name}</h1>
		<img alt="" src="image/heroImg.jpg" style="margin:15px 0 15px 0;height: 450px; width: 400px;">
		<h4 style="margin-bottom: 15px">Description: ${itemInfo.description} </h4>
		<h4 style="margin-bottom: 15px">Price: ${itemInfo.price}</h4>
		<h4 style="margin-bottom: 15px">Category: ${itemInfo.category}</h4>
		<h4 style="margin-bottom: 15px">Quantity: ${itemInfo.quantity}</h4>
		<% if(loggedIn.getType().equals("regular")){ %>
		 <button>Add to Cart</button>
		 <% } %>
		<% if(loggedIn.getType().equals("admin")){ %>
		 <button onclick="document.getElementById('addQty').style.display='block'">Add Quantity</button>
		 <button onclick="document.getElementById('changeDesc').style.display='block'" >Change Description</button>
		 <button onclick="document.getElementById('changeCat').style.display='block'">Change Category</button>
		 <button onclick="document.getElementById('changePrice').style.display='block'">>Change Price</button>
		 <button>Delete Item</button>
		 <% } %>
	</div>
	
	<div class="review" align="center" style="margin-top: 8%; max-width:700px; margin-left:27%">
		<form action="" method="get">
			<DIV class="header">
				<H3 class="headers">Product Rating</H3>
			</DIV>
			<div>
				<label for="rate" >Numerical rating</label>
				<input type="number"  min="1" max="5" name = "rate" placeholder="Enter a number between 1 and 5" required>
			</div>
			<DIV class="textInput">
				<label for="comment">A brief description</label>
				<textarea rows="5" cols="100" onkeyup="" name="comment" id="comment"
					placeholder="Enter some text here"></textarea>
				<br /> <input type="submit" onclick="" name="submit" value="Submit" />
			</DIV>
		</form>
	</div>
	
	<div id="addQty" class="modal">
		<form class="modal-content animate" action="ChangeQuantity" method="Post">
			<h3>Add Quantity</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('addQty').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pQty"><b>Quantity</b></label> <input
					type="number" min="1" placeholder="Enter the product quantity"
					name="pQty" required> 
				<button type="submit" name="pid" value="${itemInfo.productID}">Add</button>
			</div>
		</form>
		</div>
		
	<div id="changeDesc" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Change product description</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changeDesc').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pDesc"><b>Product Description</b></label> <input
					type="text" placeholder="Enter a new Product description"
					name="pDesc" required> 
				<button type="submit" name="productDesc" value="pressed">Change Description</button>
			</div>
		</form>
		</div>
		
	<div id="changeCat" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Change product category</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changeCat').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pCat"><b>Product Category</b></label> <input
					type="text" placeholder="Enter a new Product category"
					name="pCat" required> 
				<button type="submit" name="productCat" value="pressed">Change Category</button>
			</div>
		</form>
		</div>
		
		<div id="changePrice" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>CHange Price</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changePrice').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="cPrice"><b>Price</b></label> <input
					type="number" min="0.1" step="0.01" placeholder="Enter the product price"
					name="cPrice" required> 
				<button type="submit" name="changePrice" value="pressed">Change Price</button>
			</div>
		</form>
		</div>
</body>
</html>