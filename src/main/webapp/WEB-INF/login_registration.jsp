<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Stash: home inventory Login/Registration</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="background_image">
	
	<h1 class=title>Stash:</h1>
	<h2 class=subtitle>are you ready to stash some stuff?</h2>
	<br>
	<br>
	<h1 class=subtitle>Register:</h1>
	
	<form:form class="grid justify_center" action="/register" method="POST" modelAttribute="userRegister">
		<div>
			<form:input placeholder="Username" path="name"></form:input>		
			<form:errors class="col_white2" path="name"></form:errors>
		</div>

		<div>
			<form:input placeholder="Email" path="email"></form:input>		
			<form:errors class="col_white2" path="email"></form:errors>
		</div>

		<div>
			<form:input type="password" placeholder="Password" path="password"></form:input>		
			<form:errors class="col_white2" path="password"></form:errors>
		</div>

		<div>
			<form:input type="password" placeholder="Password Confirmation" path="confirm"></form:input>		
			<form:errors class="col_white2" path="confirm"></form:errors>
		</div>

		<div>
			<input class=btn_submit type="submit" value="Register"/>
		</div>
						
	</form:form>
	<br>
	<br>
	<h1 class=subtitle>Login:</h1>

	<form:form class="grid justify_center" action="/login" method="POST" modelAttribute="userLogin">
		<div>
			<form:input placeholder="Email" path="email"></form:input>
			<form:errors class="col_white2" path="email"></form:errors>

		</div>

		<div>
			<form:input type="password" placeholder="Password" path="password"></form:input>		
			<form:errors class="col_white2" path="password"></form:errors>
		</div>

		<div>
			<input class=btn_submit type="submit" value="Login"/>
		</div>		
	</form:form>
	</div>
</body>
</html>