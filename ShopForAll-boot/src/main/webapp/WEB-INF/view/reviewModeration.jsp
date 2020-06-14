<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<jsp:include page="navBar.jsp" />
	<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>

	<c:if test="${empty modReviews}">
		<h1 style="margin-top: 20%; text-align: center;">No reviews to moderate</h1>
	</c:if>

	<c:if test="${not empty modReviews}">
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

				<c:forEach items="${modReviews}" var="reviews">
					<tr>
						<td>${reviews.reviewID}</td>
						<td>${reviews.reviewDate}</td>
						<td>${reviews.emailAddress}</td>
						<td>${reviews.productID}</td>
						<td>${reviews.rating}</td>
						<td>${reviews.reviewText}</td>
						<td>
							<form action="acceptReview" method="post"
								onsubmit="return confirm('Press ok to accept this review');">
								<button name="rid" value="${reviews.reviewID}">Accept Review</button>
							</form>
						</td>
						<td>
							<form action="rejectReview" method="post"
								onsubmit="return confirm('Press ok to delete this review');">
								<button name="rid" value="${reviews.reviewID}">Reject Review</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>