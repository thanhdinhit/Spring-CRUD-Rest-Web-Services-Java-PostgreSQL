<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: Center;
	padding: 10px;
}

tr:nth-child(even) {
	background-color: #dddddd;
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
    margin-left:64%; 
    margin-right:-64%;
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
	<h1 style="text-align: center">Customers List</h1>
	<c:url var="addUrl" value="/admin/add" />

	<table border="1"
		style="border: 1px solid; width: 500px; text-align: center"; align="center">
		<thead style="background: #80D0FE">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Age</th>
				<th>City</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Code</th>
				<th colspan="4"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<c:url var="editUrl" value="/admin/update?id=${customer.id}" />
				<c:url var="deleteUrl" value="/admin/delete?id=${customer.id}" />
				<c:url var="getUrl" value="/admin/get?id=${customer.id}" />
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.name}" /></td>
					<td><c:out value="${customer.gender}" /></td>
					<td><c:out value="${customer.age}" /></td>
					<td><c:out value="${customer.city}" /></td>
					<td><c:out value="${customer.email}" /></td>
					<td><c:out value="${customer.phone}" /></td>
					<td><c:out value="${customer.code}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
					<td><a href="${deleteUrl}">Delete</a></td>
					<!--  <td><a href="${addUrl}">Add</a></td>-->
					<td><a href="${getUrl}">Detail</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="btn-group">
		<!-- <a href="${addUrl}">Add</a> -->
		<a href="${addUrl}" class="button ">Add</a>
		<c:url var="returnUrl" value="/admin" />
		<!-- <a href="${returnUrl}">Return</a> -->
		<a href="${returnUrl}" class="button">Return</a>
	</div>
	<c:if test="${empty customers}">
	There are currently no customer in the list. <a href="${addUrl}">Add</a> a customer.
</c:if>
<script>
    function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          return true;
      else
        return false;
    }
</script>    
</body>
</html>
