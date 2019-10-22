<%@page import="com.fdmgroup.model.Item"%>
<%@page import="com.fdmgroup.dao.implementation.ItemDAO"%>
<%@page import="com.fdmgroup.model.User"%>
<%@page import="com.fdmgroup.dao.implementation.ShoppingCartDAO"%>
<%@page import="com.fdmgroup.model.ShoppingCartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShoppingCart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.parallax {
	background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url(image/heroImg.jpg);
	height: 25%;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

body, html {
	height: 100%;
	margin: 0;
}

body {
	background-color: rgb(238, 238, 238);
}

.hero-text {
	text-align: center;
	position: absolute;
	top: 15%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="NavBarAdmin.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
	<%
	
		ArrayList<ShoppingCartItem> items = (ArrayList<ShoppingCartItem>) session.getAttribute("sCart");
	%>
	<%
		ShoppingCartDAO scd = new ShoppingCartDAO();

		double total = scd.getCartTotal((User) session.getAttribute("user"));
	%>
	<h1 style="text-align: center">Shopping Cart</h1>

	<div class="sales">
		<%
			if (items == null || items.size() == 0) {
		%>
		<h3 style="margin-top: 20%; text-align: center;">No Item in the
			cart, fam</h3>
		<%
			} else {
		%>
		<h3 style="text-align: center;">
			Subtotal:
			<%=total%>
		</h3>
		<table border="1" align="center" style="text-align: center;">
			<%
				for (int i = 0; i < items.size(); i++) {
			%>
			
			<tr>
				<td style="width: 300px;"><a
					href="ProductPage?pid=<%=items.get(i).getProductID()%>">
						<h3><%=items.get(i).getProductName()%></h3>
				</a>
					<h3 class="price">
						Price:
						<%=items.get(i).getPrice()%>
						each
					</h3>
					<h4 class="price">
						Quantity in cart:
						<%=items.get(i).getCartQuantity()%></h4>
					<form action="RemoveItemFromCart" method="post">
						<button name="remove" value="<%=items.get(i).getProductID()%>">Remove
							Item</button>
					</form> 
					<form action="ChangeQuantityInCart" method="Post">
						<button name="add" value="<%=items.get(i).getProductID()%>">+</button>
					</form> 
					<form action="ChangeQuantityInCart" method="Post">
						<button name="subtract" value="<%=items.get(i).getProductID()%>">-</button>
					</form> 
				</td>
			</tr>
			<% } %>
		</table>
			<form action="Checkout" method="Post">
				<button name="checkout" value="pressed">Proceed to Checkout</button>
			</form> 
			<%}%>
	</div>
</body>
</html>