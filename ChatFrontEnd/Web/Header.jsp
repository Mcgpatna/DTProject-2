<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  
</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Collaboration Site</a>
    </div>
   
      	<ul class="nav navbar-nav navbar-right">
      		<li ng-hide="currentUser.role=='ADMIN'||currentUser.role=='USER'"><a href="#/register"><span class="glyphicon glyphicon-user" ></span> Sign Up</a></li>
      		<li ng-hide="currentUser.role=='ADMIN'||currentUser.role=='USER'"><a href="#/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    	</ul>
   
    
      	<ul class="nav navbar-nav">
      	<li class="active"><a href="#/home">Home</a></li>
      	<li ng-hide="currentUser.role=='ADMIN'||currentUser.role=='USER'"><a href="#/aboutUs">AboutUs</a>
      	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">BLOG <span class="caret"></span></a>
      	<ul class="dropdown-menu">
      		<li ng-hide="currentUser.role==undefined"><a href="#/blog">Add Blog</a></li>
      		<li><a href="#showblog">Show Blog</a></li>
      		<li ng-hide="currentUser.role==undefined"><a href="#/myblog">My Blog</a></li>
	  	</ul>
        <div class="nav navbar-nav navbar-right" ng-hide="currentUser==undefined">
        	<font color="white" face="calibri" size='4'>Welcome {{currentUser.userName}}</font>
        	<input type="submit" value="Logout" ng-click="logout()"/>
        </div>
</nav>

</center>
</body>
</html>