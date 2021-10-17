<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TMASolutions</title>
</head>
<style>
table {
	font-family: tahoma, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 0px solid #dddddd;
	text-align: Center;
	padding: 15px;
}

tr:nth-child(even) {
	background-color: #dddddd;
	padding: 15px;
}
</style>
<body>

<h1 style="text-align: center">Edit Customer</h1>
<c:url var="returnUrl" value="/admin/getall" />
<c:url var="saveUrl" value="/admin/update?id=${customerAttribute.id}" />
<form:form modelAttribute="customerAttribute" method="POST" action="${saveUrl}" >
		<table border="1"
			style="border: 1px solid; width: 350px; text-align: center"
			; align="center">
			<thead style="background: #80D0FE">
		<tr>
			<td><form:label path="id">Id:</form:label></td>
			<td><form:input path="id" disabled="true"/></td>
		</tr>
		<tr>
			<td><form:label path="name">Name:</form:label></td>
			<td><form:input path="name"/></td>
		</tr>

		<tr>
			<td><form:label path="gender">Gender</form:label></td>
			<td><form:input path="gender"/></td>
		</tr>
		
		<tr>
			<td><form:label path="age">Age</form:label></td>
			<td><form:input path="age" type="number" onkeypress="return isNumberKey(event)" min="0" /></td>
		</tr>
        
        <tr>
			<td><form:label path="city">City:</form:label></td>
			<td><form:input path="city" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email:</form:label></td>
			<td><form:input path="email"/></td>
		</tr>

		<tr>
			<td><form:label path="phone">Phone</form:label></td>
			<td><form:input path="phone" type="number" onkeypress="return isNumberKey(event)" min="0"/></td>
		</tr>
		
		<tr>
			<td><form:label path="code">Code</form:label></td>
			<td><form:input path="code" type="number" onkeypress="return isNumberKey(event)" min="0"/></td>
		</tr>
		<tr>
					<td><a href="${returnUrl}"><input type="button"
							value="Return" /></a></td>
					<td><input type="submit" onclick="alert('Create successful')"
						value="Save" /></td>

				</tr>
	</table>

</form:form>
<script>
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}
</script>
</body>
</html>