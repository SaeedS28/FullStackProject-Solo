<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="StyleSheet" href="css/Payment.css" type="text/css" />
<style>
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
<title>Payment</title>
</head>
	
<body>
	<jsp:include page="navBar.jsp" />
<div class="parallax">
		<div class="hero-text">
			<h1 style="font-size: 50px">For all your shopping needs</h1>
		</div>
	</div>
<div class="row" style="margin-top: 5%; max-height: 80%;">
  <div class="col-50">
    <div class="container">
      <form action="ProcessOrder" method="post" onsubmit="return confirm('Press ok to confirm your order');" >
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fullName">Full Name</label>
            <input type="text" id="fname" name="fullName" value="${user.firstname} ${user.lastname}" required/>
            <label for="address">Street Address</label>
            <input type="text" id="adr" name="address" value="${user.address.street}" required>
            <label for="city">City</label>
            <input type="text" id="city" name="city" value="${user.address.city}" required>

            <div class="row">
              <div class="col-50">
                <label for="province">Province</label>
                <input type="text" id="province" name="province" value="${user.address.province}" required/>
              </div>
              <div class="col-50">
                <label for="Country">Country</label>
                <input type="text" id="country" name="country" value="${user.address.country}" required/>
              </div>
              <div class="col-50">
                <label for="postalcode">Postal Code</label>
                <input type="text" id="postalcode" name="postalcode" value="${user.address.postalCode}" required/>
              </div>
            </div>
          </div>

          <div class="col-50">
            <h3>Payment</h3>
			<div class="row">
              <div class="col-50">
              	<label for="cname">First name on card</label>
            	<input type="text" id="cfname" name="cardfname" required/>
              </div>
              <div class="col-50">
             	 <label for="cname">Last name on card</label>
           		 <input type="text" id="clname" name="cardlname" required/>
              </div>
            </div>
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required/>
            
            <div class="row">
              <div class="col-50">
                <label for="expmonth">Expiry Month</label>
                <input type="number" id="expmonth" name="expmonth" placeholder="01"  required/>
              </div>
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="number" id="expyear" name="expyear" placeholder="2020" required/>
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="number" id="cvv" name="cvv" placeholder="000" size="3" maxlength="3" required>
              </div>
            </div>
          </div>
          
        </div>
        <input type="submit" value="Process" class="btn" name="submit"/>
      </form>
    </div>
  </div>
</div>
</body>
</html>
