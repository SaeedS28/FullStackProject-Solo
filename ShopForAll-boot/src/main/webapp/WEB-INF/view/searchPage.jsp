<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<jsp:include page="navBar.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
	<h1 style="text-align: center">Search Results</h1>

	<div class="sales">
		<c:if test="${empty items}">
			<h3>The search yielded no results</h3>
		</c:if>
		<c:if test="${not empty items}">
		<table border="1" align="center" style="text-align: center;">
		<c:forEach items="${items}" var="item">
				<tr>
				<td style="width: 450px; height: 450px"><a
						href="ProductPage?pid=${item.productID}"> <img
						src="image/${item.productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${item.name}</h4>
						<h6 class="price">Price: $${item.price}</h6>
						<h6 class="price">${item.description}</h6>
						<h6 class="price">Quantity: ${item.quantity}</h6>
				</a></td>
				</tr>
				</c:forEach>

		</table>
		</c:if>
	</div>
</body>
</html>