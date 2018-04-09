var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider)
{
	$routeProvider.when("/",{templateUrl:"/index.html"})
				.when("/login",{templateUrl:"c_user/Login.html"})
				.when("/register",{templateUrl:"c_user/Register.html"})
				.when("/home",{templateUrl:"c_user/UserHome.html"})
				.when("/blog",{templateUrl:"c_blog/Blog.html"})
				.when("/myblog",{templateUrl:"c_blog/MyBlog.html"})
				.when("/showblog",{templateUrl:"c_blog/ShowBlogs.html"})
				.when("/approveblog",{templateUrl:"c_blog/ApproveBlog.html"})
});

myApp.run(function($rootScope,$cookieStore)
{
	console.log('inside the run() ');
	console.log($rootScope.currentUser);
	if($rootScope.currentUser==undefined)
	{
		$rootScope.currentUser=$cookieStore.get('userDetails');
	}
});


