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
<%
User loggedIn = (User)session.getAttribute("user");
 if(loggedIn.getType().equals("admin")) { %>
	<jsp:include page="NavBarAdmin.jsp" />
<% 
 }
 else{ %>
	<jsp:include page="NavBarUser.jsp" />
<% } %>
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
	<h1 style="text-align: center">Most popular items</h1>
	<div class="sales">
		<table border="1" align="center" style="text-align: center;">
			<tr>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
				</a></td><td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
						
				</a></td>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
						
				</a></td>
			</tr>
			<tr>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
						
				</a></td>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
						
				</a></td>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
				</a></td>
			</tr>
			<tr>
			<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
						
				</a></td>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
									</a></td>
				<td style="width: 300px; height: 400"><a
					href="/Bookstore/Book?bid=${randbook0}"> <img
						src="../WebContent/images/heroImg.jpg"
						style="height: 100%; width: 100%" /> 
						<h4>Tailored Jeans</h4>
						<h6 class="price">$19.99</h6>
						<h6>Some text about the jeans. Super slim and comfy lorem ipsum
							lorem jeansum. Lorem jeamsun denim lorem jeansum.</h6>
				</a></td>
			</tr>
		</table>
	</div>
</body>
</html>