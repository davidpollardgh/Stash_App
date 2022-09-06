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
	<title>Stash: edit</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="background_image">
		<h1 class=title>Stash:</h1>
		<h2 class=subtitle>Update your stuff:</h2>
		<br>
		<br>
		<form:form action="/stashes/${id}/edit" method="POST" modelAttribute="stash">
			<div class=text_center>
				<form:label path="stashItem">Item:  </form:label>
				<form:input path="stashItem"></form:input>
				<form:errors class="col_white2" path="stashItem"></form:errors>
			</div>
			<br> 
			<br>  
			<div class=text_center>
				<form:label path="stashRoom">Room:</form:label>	
				<form:input path="stashRoom"></form:input>
				<form:errors class="col_white2" path="stashRoom"></form:errors>
			</div>	
			<br>
			<br>
			<div class=text_center>	
				<form:label path="stashLocation">Spot:</form:label>
				<form:input path="stashLocation"></form:input>
				<form:errors class="col_white2" path="stashLocation"></form:errors>
			</div>	
			<br>
			<br>
			<div class=text_center>	
				<form:label path="stashNotes">Notes:</form:label>
				<form:input path="stashNotes"></form:input>
				<form:errors class="col_white2" path="stashNotes"></form:errors>
			</div>	
			<br>
			<br>
			<div class=text_center>			
				<input class=btn_submit type="submit" value="Update" />
			</div>
			<br>
			<div class=text_center>
				<a class="col_white2" href="/home" >cancel and return home</a>
			</div>
		</form:form>
	</div>
</body>
</html>