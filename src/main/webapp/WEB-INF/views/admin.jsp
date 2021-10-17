<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script >
function dis()
{
	 <form action="<c:url value="/j_spring_security_logout" />" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	    <input type="submit" />
	  </form>
}
</script>
<title>TMASolutions Admin</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<body>
   <nav class="w3-bar w3-blue">
  <a href="${pageContext.request.contextPath}/admin/add"  class="w3-button w3-bar-item">ADD</a>
  <a href="${pageContext.request.contextPath}/admin/getall"  class="w3-button w3-bar-item">LIST</a>
 <!-- <a href="#tour" class="w3-button w3-bar-item">Contact</a> --> 
  <a href="${pageContext.request.contextPath}/home"  class="w3-button w3-bar-item" onclick="dis();">LOGOUT</a>
</nav>
 
  
  
</body>
</html>