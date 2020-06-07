<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

.footer {
  position: fixed;
  left: 80%;
  bottom: 0;
  text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>

	<h1 style="text-align: center">Customer Orders</h1>

	<div class="sales">
		<c:if test="${empty po}">

			<h3 style="margin-top: 20%; text-align: center;">Nothing
				purchased yet, m8</h3>
		</c:if>

		<c:if test="${not empty po}">
			<h3 style="text-align: center;">Purchase History</h3>
			<table border="1" align="center"
				style="text-align: center; width: 800px;">
				<thead>
					<tr>
						<th>Date of purchase</th>
						<th>User</th>
						<th>Item id</th>
						<th>Quantity</th>
						<th>Price/item</th>
					</tr>
				</thead>

				<c:forEach items="${po}" var="items">
					<tr>
						<td>${items.purchaseDate}</td>
						<td>${items.emailAddress}</td>
						<td>${items.productID}</td>
						<td>${items.quantity}</td>
						<td>${items.price}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<div class="footer">
		<p>
			Total Spent: $${totalSpent}		
		</p>
	</div>
</body>
</html>