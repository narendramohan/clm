<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>

	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  		<div class="panel-heading"><span class="lead">Dear <strong>${user}</strong>, Welcome to Clustering and labeling Page.
	<a href="<c:url value="/logout" />">Logout</a> </span></div>
			
		</div>
	 	<div class="well">
	 		<a href="facebook" title="not implemented">Facebook messgae</a>
	 	</div>
   	</div>
</body>
</html>