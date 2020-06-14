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
	<jsp:include page="navBar.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
	<h1 style="text-align: center">Most popular items</h1>
	<div class="sales">
		<table border="1" align="center" style="text-align: center;">
			<tr>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[0].productID}"><img
						src="image/${pop[0].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[0].name}</h4>
						<h6 class="price">Price: ${pop[0].price}</h6>
						<h6 class="price">Quantity: ${pop[0].quantity}</h6>
						<h6 class="price">${pop[0].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[1].productID}"><img
						src="image/${pop[1].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[1].name}</h4>
						<h6 class="price">Price: ${pop[1].price}</h6>
						<h6 class="price">Quantity: ${pop[1].quantity}</h6>
						<h6 class="price">${pop[1].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[2].productID}"><img
						src="image/${pop[2].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[2].name}</h4>
						<h6 class="price">Price: ${pop[2].price}</h6>
						<h6 class="price">Quantity: ${pop[2].quantity}</h6>
						<h6 class="price">${pop[2].description}</h6>
				</a></td>
			</tr>
			<tr>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[3].productID}"><img
						src="image/${pop[3].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[3].name}</h4>
						<h6 class="price">Price: ${pop[3].price}</h6>
						<h6 class="price">Quantity: ${pop[3].quantity}</h6>
						<h6 class="price">${pop[3].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[4].productID}"><img
						src="image/${pop[4].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[4].name}</h4>
						<h6 class="price">Price: ${pop[4].price}</h6>
						<h6 class="price">Quantity: ${pop[4].quantity}</h6>
						<h6 class="price">${pop[4].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[5].productID}"><img
						src="image/${pop[5].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[5].name}</h4>
						<h6 class="price">Price: ${pop[5].price}</h6>
						<h6 class="price">Quantity: ${pop[5].quantity}</h6>
						<h6 class="price">${pop[5].description}</h6>
				</a></td>
			</tr>
			<tr>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[6].productID}"><img
						src="image/${pop[6].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[6].name}</h4>
						<h6 class="price">Price: ${pop[6].price}</h6>
						<h6 class="price">Quantity: ${pop[6].quantity}</h6>
						<h6 class="price">${pop[6].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[7].productID}"><img
						src="image/${pop[7].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[7].name}</h4>
						<h6 class="price">Price: ${pop[7].price}</h6>
						<h6 class="price">Quantity: ${pop[7].quantity}</h6>
						<h6 class="price">${pop[7].description}</h6>
				</a></td>
				<td style="width: 450px; height: 450px;"><a
						href="ProductPage?pid=${pop[8].productID}"><img
						src="image/${pop[8].productID}.JPG"
						style="height: 100%; width: 100%" /> 
						<h4>${pop[8].name}</h4>
						<h6 class="price">Price: ${pop[8].price}</h6>
						<h6 class="price">Quantity: ${pop[8].quantity}</h6>
						<h6 class="price">${pop[8].description}</h6>
				</a></td>
			</tr>
		</table>
	</div>
</body>
</html>