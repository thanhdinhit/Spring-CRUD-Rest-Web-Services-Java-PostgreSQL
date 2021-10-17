<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<style>
#formtable {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#formtable td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#formtable tr:nth-child(even){background-color: #f2f2f2;}

#formtable tr:hover {background-color: #ddd;}

#formtable th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: center;
    background-color: #2196f3;
    color: white;
}
.button {
    background-color: #2196f3;
    border: none;
    color: white;
    padding: 8px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    margin-left:78%; 
    margin-right:-78%;
    margin-top:1%;
    margin-bottom:0%;
}
.btn-group .button:not(:last-child) {
    border-bottom: none; /* Prevent double borders */
}


.btn-group .button:hover {
	background-color: #0000FF;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TMASolutions</title>
</head>
<body>
<h1 style="text-align: center">Detail Customer</h1>
<c:url var="returnUrl" value="/admin/getall" />
<c:if test="${!empty customer}">
<!--  
	<table border= "1" style="border: 2px solid #000000">
		<tr>
		<td style="width: 100px">Id</td>
		<td>${customer.id}</td>
		</tr>
		
		<tr>
		<td>Name</td>
		<td>${customer.name}</td>
		</tr>
		
		<tr>
		<td>Gender</td>
		<td>${customer.gender}</td>
		</tr>
		
		<tr>
		<td>Age</td>
		<td>${customer.age}</td>
		</tr>
        
        <tr>
		<td>City</td>
		<td>${customer.city}</td>
		</tr>
		
		<tr>
		<td>Email</td>
		<td>${customer.email}</td>
		</tr>
		
		<tr>
		<td>Phone</td>
		<td>${customer.phone}</td>
		</tr>
		
		<tr>
		<td>Code</td>
		<td>${customer.code}</td>
		</tr>
	</table>
	-->
	<table id="formtable"  border="1"
			style="border: 1px solid; width: 900px; text-align: center"
			; align="center">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Gender</th>
     <th>Age</th>
    <th>City</th>
    <th>Email</th>
     <th>Phone</th>
    <th>Code</th>
    
  </tr>
  <tr>
    <td>${customer.id}</td>
    <td>${customer.name}</td>
    <td>${customer.gender}</td>
    <td>${customer.age}</td>
    <td>${customer.city}</td>
    <td>${customer.email}</td>
    <td>${customer.phone}</td>
    <td>${customer.code}</td>
  </tr>
  </table>
  <div class="btn-group">
		<a href="${returnUrl}" class="button">Return</a>
	</div>
	</c:if>
</body>
</html>