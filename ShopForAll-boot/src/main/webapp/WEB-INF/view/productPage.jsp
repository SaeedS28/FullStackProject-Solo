
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>${itemInfo.name}</title>
</head>
<body>
	<jsp:include page="navBar.jsp" />
	<c:choose>
		<c:when test="${not empty itemInfo}">
			<div class="information" align="center"
				style="margin-top: 5%; max-width: 700px; margin-left: 30%">
				<h1>${itemInfo.name}</h1>
				<img src="image/${itemInfo.productID}.JPG"
					style="margin: 15px 0 15px 0; height: 450px; width: 450px;">
				<h4 style="margin-bottom: 15px">Description:
					${itemInfo.description}</h4>
				<h4 style="margin-bottom: 15px">Price: ${itemInfo.price}</h4>
				<h4 style="margin-bottom: 15px">
					Category:<a href="search?cat=${itemInfo.category}">
						${itemInfo.category}</a>
				</h4>
				<h4 style="margin-bottom: 15px">Quantity: ${itemInfo.quantity}</h4>

				<c:if
					test="${user.type == 'regular' && !inCart && itemInfo.quantity > 0}">
					<form action="addToCart" method="post">
						<button name="pid" value="${itemInfo.productID}">Add to
							Cart</button>
					</form>
				</c:if>

				<c:if
					test="${user.type == 'admin' || inCart || itemInfo.quantity <= 0}">
					<h4 style="margin-bottom: 15px">Item cannot be added</h4>
				</c:if>

				<c:if test="${user.type == 'admin'}">
					<button
						onclick="document.getElementById('addQty').style.display='block'">Add
						Quantity</button>
					<button
						onclick="document.getElementById('changeDesc').style.display='block'">Change
						Description</button>
					<button
						onclick="document.getElementById('changeCat').style.display='block'">Change
						Category</button>
					<button
						onclick="document.getElementById('changePrice').style.display='block'">Change
						Price</button>
				</c:if>
			</div>


			<c:if test="${purchased == true}">
				<div class="review" align="center" style="margin-top: 4%;">
					<form action="addReview" method="Post"
						onsubmit="return confirm('Review will be submitted to the administrator for approval. Continue?');">
						<DIV class="header">
							<H3 class="headers">Product Rating</H3>
						</DIV>
						<div>
							<label for="rate">Numerical rating</label> <input type="number"
								min="1" max="5" name="rate"
								placeholder="Enter a number between 1 and 5" required>
						</div>
						<DIV class="textInput">
							<label for="comment">A brief description</label> <input
								type="text" name="comment" placeholder="Enter review details"
								required maxlength="500">
							<button name="review" value="${itemInfo.productID}">Add
								Review</button>
						</DIV>
					</form>
				</div>
			</c:if>

			<div class="sales" style="margin-top: 4%;">
				<h3 style="text-align: center;">Reviews</h3>
				<c:if test="${empty revs}">
					<h4>No reviews exist. Buy this item to add one.</h4>
				</c:if>

				<c:if test="${not empty revs}">
					<table border="0px"
						style="text-align: center; font-size: 1.25em; width: 100%">
						<thead>
							<tr>
								<th align="center">Date of Review</th>
								<th align="center">User</th>
								<th align="center">Rating</th>
								<th align="center">Description</th>
							</tr>
						</thead>
						<c:forEach items="${revs}" var="reviews">
							<tr>
								<td>${reviews.reviewDate}</td>
								<td>${reviews.emailAddress}</td>
								<td>${reviews.rating}</td>
								<td>${reviews.reviewText}</td>
								<c:if
									test="${user.username == reviews.emailAddress || user.type == 'admin'}">
									<td>
										<form action="deleteReview" method="post"
											onsubmit="return confirm('Press ok to delete your review');">
											<button name="rid" value="${reviews.reviewID}">Delete
												Review</button>
										</form>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<div class="information" align="center"
				style="margin-top: 25%; max-width: 500px; margin-left: 37%">
				<h1>Item does not exist</h1>
			</div>
		</c:otherwise>
	</c:choose>


	<div id="addQty" class="modal">
		<form class="modal-content animate" action="addQty" method="Post"
			onsubmit="return confirm('Press ok to add quantity');">
			<h3>Add Quantity</h3>
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('addQty').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="quantity"><b>Quantity</b></label> <input type="number"
					min="1" placeholder="Enter the product quantity" name="quantity"
					required>
				<button type="submit" name="pid" value="${itemInfo.productID}">Add</button>
			</div>
		</form>
	</div>

	<div id="changeDesc" class="modal">
		<form class="modal-content animate" action="changeDescription"
			method="post"
			onsubmit="return confirm('Press ok to change description');">
			<h3>Change product description</h3>
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('changeDesc').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="description"><b>Product Description</b></label> <input
					type="text" placeholder="Enter a new Product description"
					name="description" required maxlength="1500">
				<button type="submit" name="pid" value="${itemInfo.productID}">Change
					Description</button>
			</div>
		</form>
	</div>

	<div id="changeCat" class="modal">
		<form class="modal-content animate" action="changeCategory"
			method="post"
			onsubmit="return confirm('Press ok to change category');">
			<h3>Change product category</h3>
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('changeCat').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="category"><b>Product Category</b></label> <input
					type="text" placeholder="Enter a new Product category"
					name="category" required maxlength="100">
				<button type="submit" name="pid" value="${itemInfo.productID}">Change
					Category</button>
			</div>
		</form>
	</div>

	<div id="changePrice" class="modal">
		<form class="modal-content animate" action="changePrice" method="post"
			onsubmit="return confirm('Press ok to change price');">
			<h3>Change Price</h3>
			<div class="imgcontainer">
				<span
					onclick="document.getElementById('changePrice').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="price"><b>Price</b></label> <input type="number"
					min="0.1" step="0.01" placeholder="Enter the product price"
					name="price" required>
				<button type="submit" name="pid" value="${itemInfo.productID}">Change
					Price</button>
			</div>
		</form>
	</div>
</body>
</html>