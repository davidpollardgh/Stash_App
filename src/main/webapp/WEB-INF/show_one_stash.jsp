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
	<title>Stash: item details</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
<div class="background_image">
	<h1 class=title>Stash:</h1>
	<h2 class=subtitle>Take a look at your stuff:</h2>
	<br>
	<br>
	<div class="stash_box centered">
		<p class="col_green font_40 text_center"> ${stash.stashItem}</p>
		<br>
		<p class="col_green">Room: ${stash.stashRoom}</p>
		
		<p class="col_green">Location: ${stash.stashLocation}</p>
		
		<p class="col_green">Notes: ${stash.stashNotes}</p>
		<br>
		<br>
	</div>	
	<div class="text_center">
		<p>
			<a class="col_white2" href="/stashes/${stash.id}/edit/">Update This Item</a>
			<a class="col_white2" href="/home">Back to all of your stuff</a>
		</p>
	</div>
</div>
</body>
</html>
