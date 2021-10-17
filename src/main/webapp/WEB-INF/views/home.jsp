 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<title>Home-TMASolutions BD</title>
</head>

<body >
    <nav class="w3-bar w3-blue">
  <a href="${pageContext.request.contextPath}/home"  class="w3-button w3-bar-item">HOME</a>
  <a href="${pageContext.request.contextPath}/infome"  class="w3-button w3-bar-item">ABOUT ME</a>
  <a href="#tour" class="w3-button w3-bar-item">CONTACT</a>
  <a href="${pageContext.request.contextPath}/login"  class="w3-button w3-bar-item">LOGIN</a>
</nav>
<!--  
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <a href="${pageContext.request.contextPath}/infome">About Me</a>
    <a href="${pageContext.request.contextPath}/login">Login</a>
-->
</body>
</html>
