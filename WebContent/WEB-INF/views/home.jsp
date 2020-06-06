<%@page import="dao.HomeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<title>Bhardwaj-Goods-Carrier</title>
<script type="text/javascript">
	function fareProcess(){
		var t=document.forms["fare-form"]["type"].value;
		var s=document.forms["fare-form"]["source"].value;
		var d=document.forms["fare-form"]["destination"].value;

		if(t==null || t=="" || t=="Type"){
			alert("Choose Type");
			return false;
		}
		else if(s==null || s=="" || s=="Source"){
			alert("Choose Source");
			return false;
		}
		else if(d==null || d=="" || d=="Destination"){
			alert("Choose Destination");
			return false;
		}
		else{
			var http = new XMLHttpRequest();
		    http.open("POST", "http://localhost:8080/CommercialTransportationPortal/home.jsp", true);
		    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		    var type = "type=" + t;
		    var source = "source=" + s;
		    var destination = "destination=" + d;
		    http.send(type,source,destination);
		    http.onload = function() { http.responseText; }
		}
	}
</script>
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

<div class="body-div2">
	<c:forEach var="v" items="${vehicleList}">
		<div class="article-card">
			<img class="card-image" src="${v.getImage()}" alt="">
			<div class="card-text">
				<h1 id="vehicle-type"><c:out value="${v.getType()}"/></h1>
				<p id="vehicle-dimension"><c:out value="${v.getDimension()}"/></p>
				<p><b><c:out value="${v.getAbout()}"/></b></p>
			</div>
		</div>
	</c:forEach>
</div>

<!-- action="${pageContext.request.contextPath}/fareProcess" method="post" -->

<div class = "body-div3">
		<form class="fare-form" name="fare-form">
			<select id="type" name="type">
				<option selected>Type</option>
				<c:forEach var="v" items="${vehicleList}">
					<option><c:out value="${v.getType()}"/></option>
				</c:forEach>
			</select>
			<select id="source" name="source">
				<option selected>Source</option>
				<c:forEach var="s" items="${routelist}">
					<option><c:out value="${s}"/></option>
				</c:forEach>
			</select>
			<select id="destination" name="destination">
				<option selected>Destination</option>
				<c:forEach var="d" items="${routelist}">
					<option><c:out value="${d}"/></option>
				</c:forEach>
			</select>
			
			<button class="fare-button" type="submit" onClick="return fareProcess()">Fare</button>
			
			<div class="fare" id="fare">
			<%
			String type=(String)request.getParameter("type");
			String source=(String)request.getParameter("source");
			String destination=(String)request.getParameter("destination");
				if(source==null){
					out.print("");
				}else{
					HomeDao homedao = new HomeDao();
					int fare = homedao.getFare(source, destination);
					if(fare==0){
						out.print("This route is not available");
					} else{
						out.print("Fare from "+source+" to "+destination+" is "+fare+"Rs.");
					}
				}
			%>
			</div>
			
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