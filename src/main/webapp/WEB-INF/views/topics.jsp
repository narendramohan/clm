<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Topics </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Topic</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${topics}" var="topic">
					<tr>
						<td>${topic.name}</td>
						<td><a href="#a" class="btn btn-danger custom-width" title="not implemented">delete</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="#a" title="not implemented">Add New Topic</a>
	 	</div>
   	</div>
</body>
</html>