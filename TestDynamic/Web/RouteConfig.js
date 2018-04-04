var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider)
{
	$routeProvider.when("/",{templateUrl:"/index.jsp"})
				.when("/login",{templateUrl:"c_user/Login.html"})
				.when("/register",{templateUrl:"c_user/Register.html"})
				.when("/home",{templateUrl:"template/Home.html"})
			
	
		});