var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider)
{
	$routeProvider.when("/",{templateUrl:"/index.html"})
				.when("/login",{templateUrl:"c_user/Login.html"})
				.when("/register",{templateUrl:"c_user/Register.html"})
				.when("/home",{templateUrl:"c_user/UserHome.html"})
				.when("/profileUpdate",{templateUrl:"c_user/UpdateProfile.html"})
				.when("/blog",{templateUrl:"c_blog/Blog.html"})
				.when("/myblog",{templateUrl:"c_blog/MyBlog.html"})
				.when("/showblog",{templateUrl:"c_blog/ShowBlogs.html"})
				.when("/approveblog",{templateUrl:"c_blog/ApproveBlog.html"})
				.when("/addJob",{templateUrl:"c_job/AddJob.html"})
				.when("/showJob",{templateUrl:"c_job/ShowJob.html"})
				.when("/blogcomment",{templateUrl:"c_blog/BlogComment.html"})
				.when("/showFriend",{templateUrl:"c_friend/ShowFriend.html"})
				.when("/showPendingFriend",{templateUrl:"c_friend/ShowPendingFriend.html"})
				.when("/showSuggestedFriend",{templateUrl:"c_friend/ShowSuggestedFriend.html"})
				.when("/chat",{templateUrl:"c_chat/chat.html"})
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


