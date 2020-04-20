<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<jsp:include page="navBar.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
	<!-- 			double total = scd.getCartTotal((User) session.getAttribute("user")); -->
	<h1 style="text-align: center">Shopping Cart</h1>

	<div class="sales">

		<c:if test="${empty cart}">
			<h3 style="margin-top: 20%; text-align: center;">No Item in the	cart, fam</h3>
		</c:if>

		<c:if test="${not empty cart}">
			<h3 style="text-align: center;">Sub-total: $${total}</h3>

			<table border="1" align="center" style="text-align: center;">
				<c:forEach items="${cart}" var="item">
					<tr>
						<td style="width: 300px;"><a
							href="ProductPage?pid=${item.productID}">
								<h3>${item.productName}</h3>
						</a>
							<h3 class="price">Price: ${item.price} each</h3>
							<h4 class="price">Quantity in cart: ${item.cartQuantity}</h4>
							<form action="RemoveItemFromCart" method="post">
								<button name="remove" value="${item.productID}">Remove
									Item</button>
							</form>
							<form action="ChangeQuantityInCart" method="Post">
								<button name="add" value="${item.productID}">+</button>
							</form>
							<form action="ChangeQuantityInCart" method="Post">
								<button name="subtract" value="${item.productID}">-</button>
							</form></td>
					</tr>
				</c:forEach>

			</table>
			<form action="checkout" method="Post">
				<button name="checkout" value="pressed">Proceed to Checkout</button>
			</form>
		</c:if>
	</div>
</body>
</html>