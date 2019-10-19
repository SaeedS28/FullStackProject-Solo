<%@page import="com.fdmgroup.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/ProductPage.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>${itemInfo.name}</title>
</head>
<body>
<%
User loggedIn = (User)session.getAttribute("user");
 if(loggedIn.getType().equals("admin")) { %>
	<jsp:include page="NavBarAdmin.jsp" />
<% 
 }
 else{ %>
	<jsp:include page="NavBarUser.jsp" />
<% } %>

	<div class="information" align="center" style="margin-top: 5%; max-width:500px; margin-left:34%">
		<h1>${itemInfo.name}</h1>
		<img alt="" src="image/heroImg.jpg" style="margin:15px 0 15px 0;height: 450px; width: 400px;">
		<h4 style="margin-bottom: 15px">Description: ${itemInfo.description} </h4>
		<h4 style="margin-bottom: 15px">Price: ${itemInfo.price}</h4>
		<h4 style="margin-bottom: 15px">Quantity ${itemInfo.quantity}</h4>
		 <button>Add to Cart</button>
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
</body>
</html>