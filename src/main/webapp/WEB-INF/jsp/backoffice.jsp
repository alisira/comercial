<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  	<head>  
    	<title>{{Title}}</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">     	
     	<link href="<c:url value='bootstrap/css/font-awesome.min.css' />" rel="stylesheet"></link>     	
		<link href="<c:url value='bootstrap/css/fonts-googleapis.css' />" rel="stylesheet"></link>
		<link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
		<link href="<c:url value='css/style_back.css' />" rel="stylesheet"></link>		
	</head>
  	
	<body id="app-layout" ng-app="myApp" class="ng-cloak">

		
		<nav class="navbar navbar-default" ng-controller="HomeController as hc">	
	        <div class="container" >
	            <div class="navbar-header">
	                <!-- Collapsed Hamburger -->
	                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#spark-navbar-collapse">
	                    <span class="sr-only">Toggle Navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	            </div>
		
	            <div class="collapse navbar-collapse" id="spark-navbar-collapse">
	                <!-- Left Side Of Navbar -->
					<ul ng-if="permission" class="nav navbar-nav">
						<li ng-repeat="per in permission track by $index">
							<a href="#!/{{per.url}}" />{{per.desc}}</a>
						</li>	
					</ul>

					<!-- Right Side Of Navbar -->
	                <ul ng-if="!permission" class="nav navbar-nav navbar-right">
	                    <!-- Authentication Links -->
                        <li><a href="/#!/login">Login</a></li>
                        <li><a href="/#!/register">Registro</a></li>
	                    
	                </ul>
	                
	                <ul ng-if="token" class="nav navbar-nav navbar-right">
	                    <!-- Authentication Links -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                {{ getUserName() }} <span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/logout"><i class="fa fa-btn fa-sign-out"></i>Logout</a></li>
                            </ul>
                        </li>	                    
	                </ul>
	            </div>
	        </div>
	    </nav>
	
	
		Inicio Vista
		<div ng-view></div>
		Fin Vista

		<br><br>
      
		<script src="<c:url value='js/jquery.js' />"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script src="js/angular.min.1.6.js"></script>
		
		<script src="<c:url value='js/angular-route.min.js' />"></script>
		<script src="<c:url value='js/app.js' />"></script>
		
		<script src="<c:url value='js/service/user_service.js' />"></script>
				
		<script src="<c:url value='js/controller/login_controller.js' />"></script>
		<script src="<c:url value='js/controller/home_controller.js' />"></script>
		

  	</body>
</html>