<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ShopForAll</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/MainPage.css">
</head>

<body>
	<div class="jumbotron">
		<h1>ShopForAll</h1>
		<h3>You shop, we drop it off</h3>

	</div>
		<form action="Login" method="post">
			<div class="container">
				<input type="text" placeholder="Enter Username" name="uname" required><br/>
				<input type="password" placeholder="Enter Password" name="psw" required> <br/>
				<button type="submit" name="loginPress" value="pressed">Login</button>
			</div>

			<div class="container psw" style="background-color: #f1f1f1">
				Forgot <a href="#">password?</a>
			</div>
		</form>
</body>
</html>