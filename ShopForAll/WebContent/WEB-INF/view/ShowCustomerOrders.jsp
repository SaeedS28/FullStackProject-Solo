<%@page import="com.fdmgroup.model.PurchaseOrder"%>
<%@page import="com.fdmgroup.dao.implementation.PurchaseOrderDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.fdmgroup.model.Item"%>
<%@page import="com.fdmgroup.dao.implementation.ItemDAO"%>
<%@page import="com.fdmgroup.model.User"%>
<%@page import="com.fdmgroup.dao.implementation.ShoppingCartDAO"%>
<%@page import="com.fdmgroup.model.ShoppingCartItem"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Orders</title>
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
		PurchaseOrderDAO pod = new PurchaseOrderDAO();
		User u = (User) request.getSession().getAttribute("user");
		ArrayList<PurchaseOrder> po = pod.getPurchaseOrdersByUser(u);
	%>
	<h1 style="text-align: center">Customer Orders</h1>

	<div class="sales">
		<%
			if (po == null || po.size() == 0) {
		%>
		<h3 style="margin-top: 20%; text-align: center;">Nothing purchased yet, m8</h3>
		<%
			} else {
		%>
		<h3 style="text-align: center;">
			Purchase History
		</h3>
		<table border="1" align="center" style="text-align: center; width: 800px;">
			<thead>
			<tr>
				<th>
					Date of purchase
				</th>
				<th>
					Item id
				</th>
				<th>
					Quantity
				</th>
				<th>
					Price/item
				</th>
			</tr>				
			</thead>
			<%
				for (int i = 0; i < po.size(); i++) {
			%>
			
			<tr>
				<td>
					<%= po.get(i).getPurchaseDate() %>
				</td>
				 <td>
				 	<%= po.get(i).getProductID() %>
				 </td>
				 <td>
				 	<%= po.get(i).getQuantity() %>
				 </td>
				 <td>
				 	<%= po.get(i).getPrice() %>
				 </td>
			</tr>
			<%}%>
			<%}%>
	</div>
</body>
</html>