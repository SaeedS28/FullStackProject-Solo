<%@page import="com.fdmgroup.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
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
<% ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("allItems"); %>
	<h1 style="text-align: center">Search Results</h1>

	<div class="sales">
		<% if(items == null || items.size()==0){ %>
			<h3>The search yielded no results</h3>
		<%} else{ %>		
		<table border="1" align="center" style="text-align: center;">
			<% for(int i = 0;i<items.size();i++) { %>
				<tr>
				<td style="width: 450px; height: 450px"><a
						href="ProductPage?pid=<%= items.get(i).getProductID() %>"> <img
						src="image/<%= items.get(i).getProductID() %>.JPG"
						style="height: 100%; width: 100%" /> 
						<h4><%= items.get(i).getName() %></h4>
						<h6 class="price">Price: <%= items.get(i).getPrice() %></h6>
						<h6 class="price"><%= items.get(i).getDescription() %></h6>
						<h6 class="price">Quantity: <%= items.get(i).getQuantity() %></h6>
				</a></td>
				</tr>
			<% } %>
			<% } %>
		</table>
	</div>
</body>
</html>