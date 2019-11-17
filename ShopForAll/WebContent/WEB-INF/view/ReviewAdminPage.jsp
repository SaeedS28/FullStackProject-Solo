<%@page import="com.fdmgroup.model.Review"%>
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
<title>Review Moderator</title>
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
		ArrayList<Review> reviews = (ArrayList<Review>) request.getAttribute("reviewMod");
	%>
		<%
			if (reviews == null || reviews.size() == 0) {
		%>
		<h1 style="margin-top: 20%; text-align: center;">No reviews to moderate</h1>
		<%
			} else {
		%>
		<h1 style="text-align: center;">Reviews pending approval</h1>
	<div class="sales" style="margin-top: 3%;">
		<table border="0" align="center"
			style="text-align: center; width: 95%;">
			<thead>
				<tr>
					<th>Review Id</th>
					<th>Review Date</th>
					<th>User</th>
					<th>Item id</th>
					<th>Rating</th>
					<th>Review text</th>
				</tr>
			</thead>
			<%
				for (int i = 0; i < reviews.size(); i++) {
			%>

			<tr>
				<td><%= reviews.get(i).getReviewID() %></td>
				<td><%= reviews.get(i).getReviewDate() %></td>
				<td><%= reviews.get(i).getEmailAddress() %></td>
				<td><%= reviews.get(i).getProductID() %></td>
				<td><%= reviews.get(i).getRating() %></td>
				<td><%= reviews.get(i).getReviewText() %></td>
				<td>
				 	<form action="AcceptReview" method="post" onsubmit="return confirm('Press ok to accept this review');">
				 		<button name="AcceptReview" value="<%=reviews.get(i).getReviewID()%>">Accept Review</button>
				 	</form>
				 </td>
				<td>
				 	<form action="DeleteReview" method="post" onsubmit="return confirm('Press ok to delete this review');">
				 		<button name="deleteReview" value="<%=reviews.get(i).getReviewID()%>">Delete Review</button>
				 	</form>
				 </td>
			</tr>
			<%}%>
			<%}%>
			</table>
			</div>
</body>
</html>