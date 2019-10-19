<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
				<a class="navbar-brand" href="MainPage">ShopForAll</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Search <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">All Items</a></li>
						<li><a href="#" onclick="document.getElementById('priceRange').style.display='block'">Price</a></li>
						<li><a href="#" onclick="document.getElementById('name').style.display='block'">Name</a></li>
						<li><a href="#" onclick="document.getElementById('cat').style.display='block'">Category</a></li>
					</ul>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Users <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="document.getElementById('addUsers').style.display='block'">Add Users</a></li>
						<li><a href="#">Delete Users</a></li>
					</ul>
				<li><a href="#"  onclick="document.getElementById('addItem').style.display='block'" >Add Item</a></li>
				<li><a href="#"> See Customers History</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						User</a></li>
				<li onclick="document.getElementById('setting').style.display='block'"><a
					href="#"><span class="glyphicon glyphicon-list-alt"></span>
						Settings</a></li>
				<li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
				</ul>
		</div>
	</nav>
	<div id="setting" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Change Password</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('setting').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="cPassword"><b>Current Password</b></label> <input
					type="password" placeholder="Enter Current Password"
					name="cPassword" required> <label for="nPassword"><b>New
						Password</b></label> <input type="password" placeholder="Enter New Password"
					name="nPassword" required> <label for="rPassword"><b>Confirm
						Password</b></label> <input type="password" placeholder="Re-enter Password"
					name="Password" required>

				<button type="submit">Change Password</button>
			</div>
		</form>
		</div>
			
		<div id="priceRange" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Price Search</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('priceRange').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="minPrice"><b>Minimum Price</b></label> <input
					type="number" placeholder="Enter Minimum Price"
					name="minPrice" required> <label for="maxPrice"><b>Maximum Price
					</b></label> <input type="number" placeholder="Enter Maximum Price"
					name="maxPrice" required> 
				<button type="submit">Search Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="name" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Name Search</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('name').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="pName"><b>Product Name</b></label> <input
					type="text" placeholder="Enter the Product Name"
					name="pName" required> 
				<button type="submit">Search Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="cat" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Category Search</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('cat').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				 <a href="">Category A </a>
				 <a href="">Category B </a>
				 <a href="">Category C </a>
				 <a href="">Category D </a>
			</div>
		</form>
		</div>
		
		<div id="addItem" class="modal">
		<form class="modal-content animate" action="" method="post">
			<h3>Add new Item</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('addItem').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<label for="pName"><b>Product Name</b></label> <input type="text"
				placeholder="New Product Name" name="pName" required> <label
				for="price"><b>Price</b></label> <input type="number"
				placeholder="New Product Price" name="pPrice" required step="0.01" min="0.01"> <label
				for="pQuantity"><b>Quantity</b></label> <input type="number"
				placeholder="New Product Quantity" name="pQuantity" required min="1"> <label
				for="pDesc"><b>Description</b></label> <input type="text"
				placeholder="New Product Description" name="pDesc" required> <label
				for="pCat"><b>Category</b></label> <input type="text"
				placeholder="New Product Category" name="pCat" required>
			<button type="submit">Add Item to Catalog</button>
			</div>
		</form>
		</div>
		
		<div id="addUsers" class="modal">
		<form class="modal-content animate" action="AddUser" method="post">
			<h3>Add New User</h3>
			<div class="imgcontainer">
				<span onclick="document.getElementById('addUsers').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
			<label for="userName"><b>Username</b></label> <input type="text"
				placeholder="Enter new username" name="userName" required> 
			<label for="newPassword"><b>Password</b></label> <input type="password"
				placeholder="Enter new Password" name="newPassword" required> 				
				<label for="firstName"><b>First Name</b></label> <input type="text"
				placeholder="Enter First Name" name="firstName" required > <label
				for="lastName"><b>Last Name</b></label> <input type="text"
				placeholder="Enter Last Name" name="lastName" required > 
				<label for ="userType">User type</label>
				<select name= "userType" required>
  					<option value="regular">Customer</option>
  					<option value="admin">Administrator</option>
				</select>
				<label for="street"><b>Street Address</b></label> <input type="text"
				placeholder="New Street Address" name="street" required> <label
				for="city"><b>City</b></label> <input type="text"
				placeholder="New City" name="city" required> <label
				for="province"><b>Province</b></label> <input type="text"
				placeholder="New Province" name="province" required> <label
				for="country"><b>Country</b></label> <input type="text"
				placeholder="New Country" name="country" required> <label
				for="pCode"><b>Province</b></label> <input type="text"
				placeholder="New Postal Code" name="pCode" required>
			<button type="submit" name="addUserButton" value="pressed">Add New User</button>
			</div>
		</form>
		</div>
</body>
</html>