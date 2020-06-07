<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Something went wrong</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">

body, html {
	height: 100%;
	margin: 0;
}

body {
	background-color: rgb(238, 238, 238);
}

}
</style>
</head>
<body>
	<div class="sales">
		<h3 style="margin-top: 20%; text-align: center;">Something went wrong on our end :(</h3>
		
		<h4 style="margin-top: 10%; text-align: center;">Server returned a <%=exception.getClass().getName()%></h4>
	</div>
</body>
</html>