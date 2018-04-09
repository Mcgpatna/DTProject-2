<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>ABC Corporation</title>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-cookies.js"></script>
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="RouteConfig.js"></script>
  <script src="c_user/UserController.js"></script>
  <script src="c_blog/BlogController.js"></script>
  
  
</head>
<html>
<jsp:include page="Header.jsp"/>
<body ng-app="myApp">


<!-- <h3 align="center">Home Page</h3> -->
<div ng-view>

</div>
<!-- <div class="container">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    Indicators
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    Wrapper for slides
    <div class="carousel-inner">
      <div class="item active">
        <img src="resource\image\m3.jpg" alt="Moto G" style="width:200%;">
      </div>

      <div class="item">
        <img src="resource\image\m1.jpg" alt="Moto G" style="width:200%;">
      </div>
    
      <div class="item">
        <img src="resource\image\m2.jpg" alt="Moto G" style="width:200%;">
      </div>
      <div class="item">
        <img src="resource\image\m4.jpg" alt="Moto G" style="width:200%;">
      </div>
    </div>

    Left and right controls
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div> -->

</body>
<jsp:include page="footer.jsp" />




</html>