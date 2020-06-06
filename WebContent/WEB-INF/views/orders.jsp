<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./css/orders.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<title>My Orders</title>
</head>
<body>
<nav>
	<img class="logo" src="./assets/logo2.png" alt="logo"/>
	<ul>
		<li><a href = "${pageContext.request.contextPath}/customerHome">Home</a></li>
		<li><a href = "${pageContext.request.contextPath}/orders">My Orders</a></li>
		<li><a href = "${pageContext.request.contextPath}/login">Logout</a></li>
	</ul>
</nav>


<div class="table-div">
<table>

	<tr>
		<th>SOURCE</th>
		<th>DESTINATION</th>
		<th>FARE</th>
		<th>STATUS</th>
		<th>TRUCK No.</th>
	</tr>
	<c:forEach var="o" items="${ordersList}">
		<tr>
			<td><c:out value="${o.getSource()}"/></td>
			<td><c:out value="${o.getDestination()}"/></td>
			<td><c:out value="${o.getFare()}"/></td>
			<td><c:out value="${o.getStatus()}"/></td>
			<td><c:out value="${o.getTrucknum()}"/></td>
		</tr>
	</c:forEach>
</table>
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