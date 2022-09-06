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
	<title>Stash Dashboard</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
	<style>
		body{
		background-image: images("Stash_background_image2.png");
		background-repeat: no-repeat;
		background-attachment: fixed;
		background-size: cover;
		}
	</style>
</head>
	<body>
	  <div class="background_image">
		<h1 class=title>Stash:</h1>
		<br>
		<h2 class=subtitle>Hello, ${user.name}!  Here's your stuff:</h2>  
		<br>
		<a class="ml5 font_40 col_white1" href="/stashes/new">Stash more stuff</a>
		<a class="col_green" href="#">Create Private Stash</a>
		<a class="col_green" href="#">View/Edit Private Stash</a>
		<a class="col_green" href="#">Generate checklist</a>
		<a class="col_white1" id=logout href="/logout">logout</a>
		<br>
		<div class="mt2 tableFixHead">
			<table class="ml5 mt5 mr5">
				<thead>
					<tr>
						<th>Item</th>
						<th>Room</th>
						<th>Location</th>
						<th>Notes</th>
						<th colspan="2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stash" items="${stashes}">
						<tr>
							<td><a href = "/stashes/${stash.id}">${stash.stashItem}</a></td>
							<td>${stash.stashRoom}</td>
							<td>${stash.stashLocation}</td>
							<td>${stash.stashNotes}</td>
							<td>
								<a class=p1 href="/stashes/${stash.id}/edit/">Edit </a>
								<td>	
								<form action="/stashes/delete/${stash.id}" method="POST">
									<input type= "submit" value="Delete" />
								</form>
							</td>
						</tr>				
					</c:forEach>	
				</tbody>
			</table>
		</div>		
	 </div>
  </body>
</html>