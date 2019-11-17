<%@page import="com.fdmgroup.model.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fdmgroup.dao.implementation.ReviewDAO"%>
<%@page import="com.fdmgroup.dao.implementation.PurchaseOrderDAO"%>
<%@page import="com.fdmgroup.model.Item"%>
<%@page import="com.fdmgroup.dao.implementation.ShoppingCartDAO"%>
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
<% User loggedIn = (User)session.getAttribute("user");
ShoppingCartDAO scd = new ShoppingCartDAO();
Item item = (Item) request.getAttribute("itemInfo");
boolean isAdded = scd.isItemInCart(loggedIn, item.getProductID());
%>
	<div class="information" align="center" style="margin-top: 5%; max-width:500px; margin-left:34%">
		<h1>${itemInfo.name}</h1>
		<img alt="" src="image/${itemInfo.productID}.JPG" style="margin:15px 0 15px 0;height: 450px; width: 450px;">
		<h4 style="margin-bottom: 15px">Description: ${itemInfo.description} </h4>
		<h4 style="margin-bottom: 15px">Price: ${itemInfo.price}</h4>
		<h4 style="margin-bottom: 15px">Category: ${itemInfo.category}</h4>
		<h4 style="margin-bottom: 15px">Quantity: ${itemInfo.quantity}</h4>
		
		<% if(loggedIn.getType().equals("regular") && !isAdded && item.getQuantity()>0){ %>
		<form action="AddItemToCart" method="post" >
		 	<button name= "pid" value="<%=item.getProductID()%>">Add to Cart</button>
		</form>
		 <% } else{%>
		 	<h4 style="margin-bottom: 15px">Item cannot be added </h4>
		 <% } %>
		 
		<% if(loggedIn.getType().equals("admin")){ %>
		 <button onclick="document.getElementById('addQty').style.display='block'">Add Quantity</button>
		 <button onclick="document.getElementById('changeDesc').style.display='block'" >Change Description</button>
		 <button onclick="document.getElementById('changeCat').style.display='block'">Change Category</button>
		 <button onclick="document.getElementById('changePrice').style.display='block'">Change Price</button>
		 <form action="DeleteItem" method="post">
		 	<button name="delButt" value="${itemInfo.productID}">Delete Item</button>
		 </form>
		 <% } %>
	</div>
	
	<% Integer i = (Integer) request.getAttribute("bought");%>
	<% if(loggedIn.getType().equals("regular") && i>0){ %>
	<div class="review" align="center" style="margin-top: 4%; max-width:700px; margin-left:27%">
		<form action="AddReview" method="Post" onsubmit="return confirm('Review submitted to the administrator for approval. Continue?');">
			<DIV class="header">
				<H3 class="headers">Product Rating</H3>
			</DIV>
			<div>
				<label for="rate" >Numerical rating</label>
				<input type="number"  min="1" max="5" name = "rate" placeholder="Enter a number between 1 and 5" required>
			</div>
			<DIV class="textInput">
				<label for="comment">A brief description</label>
				<input type="text" name="comment"
					placeholder="Enter review details" required maxlength="500">
				<button name="review" value="<%=item.getProductID()%>">Add Review</button>
			</DIV>
		</form>
	</div>
	<%} %>
	
	<%
		ReviewDAO rd = new ReviewDAO();
		ArrayList<Review> rev = rd.retrieveAcceptedReviews(item.getProductID());
	%>
	<div class="sales" style="margin-top: 4%;">
		<h3 style="text-align: center;">
			Reviews
		</h3>
		<%if(rev == null || rev.size()==0) {%>
		<h4>No reviews exist. Buy this item to add one.</h4>
		<%} else{ %>
		
		<table border="0px" style="text-align: center; font-size:1.25em; width:100%">
			<thead>
			<tr>
				<th align="center">
					Date of Review
				</th>
				<th align="center">
					User
				</th>
				<th align="center">
					Rating
				</th>
				<th align="center">
					Description
				</th>
			</tr>	
			</thead>
			<%for(int j =0;j<rev.size();j++){ %>
			<tr>
				<td>
					<%= rev.get(j).getReviewDate() %>
				</td>
				 <td>
				 	<%= rev.get(j).getEmailAddress() %>
				 </td>
				 <td>
				 	<%= rev.get(j).getRating() %>
				 </td>
				 <td>
				 	<%= rev.get(j).getReviewText() %>
				 </td>
				 <% if(loggedIn.getUsername().equals(rev.get(j).getEmailAddress())||loggedIn.getType().equals("admin")){ %>
				 <td>
				 	<form action="DeleteReview" method="post" onsubmit="return confirm('Press ok to delete your review');">
				 		<button name="deleteReview" value="<%=rev.get(j).getReviewID()%>">Delete Review</button>
				 	</form>
				 </td>
				 <%} %>
			</tr>
			<%} %>
			</table>
	<%} %>
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
		<form class="modal-content animate" action="ChangeDescription" method="post">
			<h3>Change product description</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changeDesc').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pDesc"><b>Product Description</b></label> <input
					type="text" placeholder="Enter a new Product description"
					name="pDesc" required> 
				<button type="submit" name="pid" value="${itemInfo.productID}">Change Description</button>
			</div>
		</form>
		</div>
		
	<div id="changeCat" class="modal">
		<form class="modal-content animate" action="ChangeCategory" method="post">
			<h3>Change product category</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changeCat').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pCat"><b>Product Category</b></label> <input
					type="text" placeholder="Enter a new Product category"
					name="pCat" required> 
				<button type="submit" name="pid" value="${itemInfo.productID}">Change Category</button>
			</div>
		</form>
		</div>
		
		<div id="changePrice" class="modal">
		<form class="modal-content animate" action="ChangePrice" method="post">
			<h3>Change Price</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('changePrice').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="cPrice"><b>Price</b></label> <input
					type="number" min="0.1" step="0.01" placeholder="Enter the product price"
					name="cPrice" required> 
				<button type="submit" name="pid" value="${itemInfo.productID}">Change Price</button>
			</div>
		</form>
		</div>
</body>
</html>