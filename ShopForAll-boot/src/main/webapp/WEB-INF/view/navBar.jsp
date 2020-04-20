<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NavBar</title>
</head>
<body>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/navBarUser.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="main">ShopForAll</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="">Search <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="search?allItems=true">All Items</a></li>
						<li><a href="#" onclick="document.getElementById('priceRange').style.display='block'">Price</a></li>
						<li><a href="#" onclick="document.getElementById('name').style.display='block'">Name</a></li>
						<li><a href="category">Category</a></li>
					</ul>
				<c:if test="${user.type == 'admin'}">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="">Users <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="document.getElementById('addUsers').style.display='block'">Add Users</a></li>
							<li><a href="#" onclick="document.getElementById('disableUser').style.display='block'">Deactivate Users</a></li>
							<li><a href="#" onclick="document.getElementById('enableUser').style.display='block'">Activate Users</a></li>
						</ul>
					<li><a href="#"  onclick="document.getElementById('addItem').style.display='block'" >Add Item</a></li>
					<li><a href="SeePurchaseHistory"> See Customers History</a></li>
					<li><a href="ModerateReviewPage"> Moderate Reviews</a></li>
				</c:if>
				<li><a href="mailto:Saad.Saeed@fdmgroup.com?Subject=I%20have%20an%20inquiry">Contact Us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			
			<c:choose>
				  <c:when test="${user.type == 'regular'}">
				<li><a href="SeePurchaseHistory"><span class="glyphicon glyphicon-user"></span>
						${user.firstname} ${user.lastname}</a></li>
				</c:when>
				<c:otherwise>
				<li><a><span class="glyphicon glyphicon-user"></span>
						${user.firstname} ${user.lastname}</a></li>
				</c:otherwise>
			</c:choose>
				<li onclick="document.getElementById('setting').style.display='block'"><a
					href="#"><span class="glyphicon glyphicon-list-alt"></span>
						Settings</a></li>
						
				<c:if test="${user.type == 'regular'}">
							<li><a href="ShoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
						</c:if>
				<li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
				</ul>
		</div>
	</nav>
	<div id="setting" class="modal">
		<form class="modal-content animate" action="changePassword" method="post">
			<h3>Change Password</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('setting').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="currentPassword"><b>Current Password</b></label> 
				<input type="password" placeholder="Enter Current Password" name="currentPassword" required> 
				<label for="newPassword"><b>New	Password</b></label> 
				<input type="password" placeholder="Enter New Password"	name="newPassword" minLength="7" required> 
				<label for="repeatPassword"><b>Confirm Password</b></label> 
				<input type="password" placeholder="Enter New Password"	name="repeatPassword" minLength="7" required>

				<button type="submit" name="passwordChange" value="pressed">Change Password</button>
			</div>
		</form>
		<c:if test="${user.type == 'regular'}">
	<form class="modal-content animate" action="ChangeAddress" method="post">
			<h3>Change Address</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('setting').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<label for="street"><b>Street Address</b></label> <input type="text"
				 name="street" value ="${user.address.street}" required> <label
				for="city"><b>City</b></label> <input type="text"
			 	name="city" value="${user.address.city}" required> <label
				for="province"><b>Province</b></label> <input type="text"
				name="province" value="${user.address.province}" required> <label
				for="country"><b>Country</b></label> <input type="text"
				name="country" value="${user.address.country}" required> <label
				for="postalCode"><b>Postal Code</b></label> <input type="text"
				name="postalCode" value="${user.address.postalCode}" required>
			<button type="submit" name="addressChange" value="pressed">Change Address</button>
			</div>
		</form>
		</c:if>
		</div>
			
		<div id="priceRange" class="modal">
		<form class="modal-content animate" action="search" method="Get">
			<h3>Price Search</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('priceRange').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="minPrice"><b>Minimum Price</b></label> <input
					type="number" placeholder="Enter Minimum Price"
					name="minPrice" required step="0.01" min="0"> <label for="maxPrice"><b>Maximum Price
					</b></label> <input type="number" placeholder="Enter Maximum Price"
					name="maxPrice" required step="0.01" min="0"> 
				<button type="submit" name="price" value="pressed">Search Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="name" class="modal">
		<form class="modal-content animate" action="search" method="Get">
			<h3>Name Search</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('name').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pName"><b>Product Name</b></label> <input
					type="text" placeholder="Enter the Product Name"
					name="pName" required> 
				<button type="submit" name="searchName" value="pressed">Search Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="disableUser" class="modal">
		<div class="modal-content animate">
			<h3>Deactivate</h3>
			<h4 style="padding-left: 10px">Click on button</h4>
			<div class="imgcontainer">
				<span onclick="document.getElementById('disableUser').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div style="text-align: center; margin-left: 0;">
			 <ul  style="font-size: 1.5em; list-style-type:none;">
			 <form class="modal-content animate" action="disableUser" method="post">
			 <table width="100%">
				  <tr>
				  	<th>Choice</th>
				    <th>User Name</th>
				    <th>First Name</th>
				    <th>Last Name</th>
				    <th>User Type</th>
				  </tr>
			 <c:forEach items="${active}" var="allUsers">
				  <tr style="text-align: left;">
				  <td><input type="radio" name="username" value="${allUsers.username}" required /></td>
				    <td>${allUsers.username}</td>
				    <td>${allUsers.firstname}</td>
				    <td>${allUsers.lastname}</td>
				    <td>${allUsers.type}</td>
				  </tr>
			</c:forEach>
			</table>
			<button type="submit">Deactivate User</button>
			</form>
			</ul>
			</div>
			</div>
			</div>
		
		<div id="enableUser" class="modal">
		<div class="modal-content animate">
			<h3>Activate</h3>
			<h4 style="padding-left: 10px">Click on button</h4>
			<div class="imgcontainer">
				<span onclick="document.getElementById('enableUser').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div style="text-align: center; margin-left: 0;">
			 <ul  style="font-size: 1.5em; list-style-type:none;">
			 
			 <c:if test="${empty inactive}">
			 <h2>No deactivated users</h2>
			 </c:if>
			 
			 <c:if test="${not empty inactive}">
			 <form class="modal-content animate" action="enableUser" method="post">
			 <table width="100%">
				  <tr>
				  	<th>Choice</th>
				    <th>User Name</th>
				    <th>First Name</th>
				    <th>Last Name</th>
				    <th>User Type</th>
				  </tr>
			 <c:forEach items="${inactive}" var="allUsers">
				  <tr style="text-align: left;">
				  <td><input type="radio" name="username" value="${allUsers.username}" required/></td>
				    <td>${allUsers.username}</td>
				    <td>${allUsers.firstname}</td>
				    <td>${allUsers.lastname}</td>
				    <td>${allUsers.type}</td>
				  </tr>
			</c:forEach>
			</table>
			<button type="submit">Activate User</button>
			</form>
			</c:if>
			</ul>
			</div>
			</div>
			</div>
			
		<div id="addItem" class="modal">
		<form class="modal-content animate" action="addItem" method="post" enctype="multipart/form-data">
			<h3>Add new Item</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('addItem').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<label for="name"><b>Product Name</b></label> 
			<input type="text" placeholder="New Product Name" name="name" required maxlength="69"> 
			<label for="price"><b>Price</b></label> 
			<input type="number" placeholder="New Product Price" name="price" required step="0.01" min="0.01"> 
			<label for="quantity"><b>Quantity</b></label> 
			<input type="number" placeholder="New Product Quantity" name="quantity" min="1" required> 
			<label for="description"><b>Description</b></label> 
			<input type="text" placeholder="New Product Description" name="description" required maxlength="1500"> 
			<label for="category"><b>Category</b></label> 
			<input type="text" placeholder="New Product Category" name="category" required maxlength="100">
			<label for="pic"><b>Image upload</b></label>
			<input type="file" name="pic" required>
			<button type="submit" name="add" value="pressed">Add Item to Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="addUsers" class="modal">
		<form class="modal-content animate" action="addUser" method="post">
			<h3>Add New User</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('addUsers').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			
			<div class="container">
			<label for="username"><b>Username</b></label> 
			<input type="text" placeholder="Enter new username" name="username" required> 
			<label for="password"><b>Password</b></label> 
			<input type="password" placeholder="Enter new Password" name="password" required minLength="5"> 				
			<label for="firstname"><b>First Name</b></label> 
			<input type="text" placeholder="Enter First Name" name="firstname" required > 
			<label for="lastname"><b>Last Name</b></label> 
			<input type="text" placeholder="Enter Last Name" name="lastname" required > 
			<label for="type">User type</label>
			<select name= "type" required>
  				<option value="regular">Customer</option>
  				<option value="admin">Administrator</option>
			</select>
			
			<label for="street"><b>Street Address</b></label> 
			<input type="text" placeholder="New Street Address" name="street" required> 
			<label for="city"><b>City</b></label> 
			<input type="text" placeholder="New City" name="city" required> 
			<label for="province"><b>Province</b></label> 
			<input type="text" placeholder="New Province" name="province" required> 
			<label for="country"><b>Country</b></label> 
			<input type="text" placeholder="New Country" name="country" required> 
			<label for="postalCode"><b>Postal Code</b></label> 
			<input type="text" placeholder="New Postal Code" name="postalCode" required>
			<button type="submit" name="addUserButton" value="pressed">Add New User</button>
			</div>
		</form>
		</div>
</body>
</html>