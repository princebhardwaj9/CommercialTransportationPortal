<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<title>Login</title>
</head>
<body>
<nav>
	<img class="logo" src="./assets/logo2.png" alt="logo"/>
	<ul>
		<li><a href = "${pageContext.request.contextPath}/home">Home</a></li>
		<li><a href = "${pageContext.request.contextPath}/login">Login</a></li>
		<li><a href = "${pageContext.request.contextPath}/signup">SignUp</a></li>
	</ul>
</nav>
<div class="login-div">
	<form action= "${pageContext.request.contextPath}/login" method="post"> <!-- action= "login" method="post" -->
	<h2>Login</h2>
	<input type="email" id="email" name="email" placeholder="email">
	<input type="password" id="password" name="password" placeholder="password">
	<button type="submit" class="login-button">Login</button>
	<div class="message">${message}</div>
	</form>
</div>


<div class="body-div4">
    <div class="card-header">
      <h1>Contact Us</h1>
    </div>
    <div class="card-body">
      <img src="assets/logo2.png" width="150" height="40" alt="">
      <h3 class="card-title">BHARDWAj-GOODS-CARRIER</h3>
      <p class="card-text">For any queries contact us on: 9034885110, 8397030300</p>
      <a class="brand" href="https://www.instagram.com/">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/1200px-Instagram_logo_2016.svg.png" width="30" height="30" alt="">
      </a>
      <a class="brand" href="https://www.facebook.com/">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSUZaeLfDjQDJIBiwSwEK2f7h-JJ5ZZB0skzXSWgY89IrP5wz73&usqp=CAU" width="30" height="30" alt="">
      </a>
    </div>
    <div class="card-footer">
        In service since 1981
        <br>
        Real Artists Ship
    </div>
</div>

</body>
</html>