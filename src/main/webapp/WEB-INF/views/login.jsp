
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Login</title>
	 <style type = "text/css" media = "all">
           form {
  box-sizing: border-box;
  width: 260px;
  margin: 100px auto 0;
  box-shadow: 2px 2px 5px 1px rgba(0, 0, 0, 0.2);
  padding-bottom: 40px;

  border-radius: 3px;
}
form h1 {
  box-sizing: border-box;
  padding: 20px;
}
 
input {
  margin: 40px 25px;
  width: 200px;
  display: block;
  border: none;
  padding: 10px 0;
  border-bottom: solid 1px #1abc9c;
  transition: all 0.3s cubic-bezier(0.64, 0.09, 0.08, 1);
  background: linear-gradient(to bottom, rgba(255, 255, 255, 0) 96%, #1abc9c 4%);
  background-position: -200px 0;
  background-size: 200px 100%;
  background-repeat: no-repeat;
  color: #2196f3;
}
input:focus, input:valid {
  box-shadow: none;
  outline: none;
  background-position: 0 0;
}
input:focus::-webkit-input-placeholder, input:valid::-webkit-input-placeholder {
  color: #2196f3;
  font-size: 0px;
  transform: translateY(0px);
  visibility: visible !important;
}
 
button {
  border: none;
  background: #2196f3;
  cursor: pointer;
  border-radius: 3px;
  padding: 6px;
  width: 200px;
  color: white;
  margin-left: 25px;
  box-shadow: 0 3px 6px 0 rgba(0, 0, 0, 0.2);
}
button:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 6px 0 rgba(0, 0, 0, 0.2);
}
         }
         
      </style>
     
</head>

<body>
<!--  
<h1>
	TMA Solutions Lab8 Binh Dinh  
</h1>
<P>  ${serverTime}. </P>
-->
<!-- 
 <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST' >
    <table>
      <tr>
        <td>User:</td>
        <td><input type='text' name='username'></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
      </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
-->
 <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST' >
    <table >
    <h1 style="color:#2196f3;"><center>Login</center></h1>
       <input placeholder="Username" name='username' type="text" required="">
  		<input placeholder="Password" name='password' type="password" required="">
  		<button >Submit </button>  
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  
  </form>
</body>
</html>
