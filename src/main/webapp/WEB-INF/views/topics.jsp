<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	 <!-- FONTAWESOME STYLES-->
    <link href="<c:url value='/static/css/font-awesome.css' />" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="<c:url value='/static/js/morris/morris-0.4.3.min.css" rel="stylesheet' />" />
        <!-- CUSTOM STYLES-->
    <link href="<c:url value='/static/css/custom.css" rel="stylesheet' />" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value='/home' />">${user}</a> 
            </div>
		  <div style="color: white;
		padding: 15px 50px 5px 50px;
		float: right;
		font-size: 16px;"> Last access : ${lastAccessed} &nbsp; <a href="<c:url value="/logout" />" class="btn btn-danger square-btn-adjust">Logout</a> </div>
		        </nav>	
	<nav class="navbar-default navbar-side" role="navigation">
	   <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="<c:url value='/static/img/find_user.png' />" class="user-image img-responsive"/>
					</li>
				
					
                    <li>
                        <a href="<c:url value='/home' />"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                    <li  >
                        <a  class="active-menu"  href="admin/topics"><i class="fa fa-table fa-3x"></i> Topics</a>
                    </li>
                     <!-- <li>
                        <a  href="ui.html"><i class="fa fa-desktop fa-3x"></i> UI Elements</a>
                    </li>
                    <li>
                        <a  href="tab-panel.html"><i class="fa fa-qrcode fa-3x"></i> Tabs & Panels</a>
                    </li>
						   <li  >
                        <a   href="chart.html"><i class="fa fa-bar-chart-o fa-3x"></i> Morris Charts</a>
                    </li>	
                      <li  >
                        <a  href="table.html"><i class="fa fa-table fa-3x"></i> Table Examples</a>
                    </li>
                    <li  >
                        <a  href="form.html"><i class="fa fa-edit fa-3x"></i> Forms </a>
                    </li>				
					
					                   
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-3x"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>
                               
                            </li>
                        </ul>
                      </li>   -->
                  <li  >
                        <a  href="#a"><i class="fa fa-square-o fa-3x"></i> Blank Page</a>
                    </li>	
                </ul>
               
            </div>
            
        </nav>
          
        <div id="page-wrapper" >
			<div id="page-inner">
				<div class="row">
                    <div class="col-md-12">
                     <h2>Admin Dashboard</h2>   
                        <h5>Welcome ${user} , Love to see you back. </h5>
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                          <!-- /. ROW  -->
            	<div class="row">
            		<div class="col-md-12">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            Topics
                        </div>
                        <div class="panel-body">
                        <div class="table-responsive">
                                <table class="table table-striped">
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
                        </div>
                        <div class="panel-footer">
                            
                        </div>
                      </div>
                      </div>
            	</div>
			</div>
		</div>
   	</div>
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<c:url value='/static/js/jquery.metisMenu.js'/>"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="<c:url value='/static/js/morris/raphael-2.1.0.min.js'/>"></script>
    <script src="<c:url value='/static/js/morris/morris.js'/>"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value='/static/js/custom.js'/>"></script>   	
</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Topic List</title>
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
</html> --%>