<%@page import="java.util.List"%>
<%@page import="com.fdmgroup.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fdmgroup.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShopForAll: Featured</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">
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
body{
	background-color: rgb(238,238,238);
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
	<h1 style="text-align: center">Most popular items</h1>
		<% List<Item> pop = (List<Item>) request.getAttribute("topPurchase"); %>
	<div class="sales">
		<table border="1" align="center" style="text-align: center;">
			<tr>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=<%= pop.get(0).getProductID() %>"> <img
						src="image/<%= pop.get(0).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(0).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(0).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(0).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(0).getDescription() %></h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(1).getProductID() %>"> <img
						src="image/<%= pop.get(1).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(1).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(1).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(1).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(1).getDescription() %></h6>
						
				</a></td>
				<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(2).getProductID() %>"> <img
						src="image/<%= pop.get(2).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(2).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(2).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(2).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(2).getDescription() %></h6>						
				</a></td>
			</tr>
			<tr>
				<td style="width: 450px; height: 450px;"><a
				href="ProductPage?pid=<%= pop.get(3).getProductID() %>"> <img
						src="image/<%= pop.get(3).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(3).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(3).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(3).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(3).getDescription() %></h6>
				</a></td>
				<td style="width: 300px; height: 300px;"><a
					href="ProductPage?pid=<%= pop.get(4).getProductID() %>"> <img
						src="image/<%= pop.get(4).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(4).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(4).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(4).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(4).getDescription() %></h6>
						
				</a></td>
				<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(5).getProductID() %>"> <img
						src="image/<%= pop.get(5).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(5).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(5).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(5).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(5).getDescription() %></h6>
				</a></td>
			</tr>
			<tr>
			<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(6).getProductID() %>"> <img
						src="image/<%= pop.get(6).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(6).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(6).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(6).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(6).getDescription() %></h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(7).getProductID() %>"> <img
						src="image/<%= pop.get(7).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(7).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(7).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(7).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(7).getDescription() %></h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
					href="ProductPage?pid=<%= pop.get(8).getProductID() %>"> <img
						src="image/<%= pop.get(8).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= pop.get(8).getName() %></h4>
						<h6 class="price">Price: <%= pop.get(8).getPrice() %></h6>
						<h6 class="price">Quantity: <%= pop.get(8).getQuantity() %></h6>
						<h6 class="price"> <%= pop.get(8).getDescription() %></h6>
				</a></td>
			</tr>
		</table>
	</div>
</body>
</html>