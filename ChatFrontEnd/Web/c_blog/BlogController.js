myApp.controller("BlogController",function($scope,$rootScope,$location,$http,$cookieStore)
 {
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',likes:0,loginName:'',status:''};
	
	$scope.blogComment={commentId:0,commentText:'',loginName:'',blogId:0,commentDate:''};
	
	console.log($scope.blog);
	$scope.blogdata;
	$scope.showBlogData;
	$scope.showNBlog;
	
	$rootScope.blogCommentData;
	$rootScope.blogId;
	
	
	var url='http://localhost:8082/ChatMiddleware/';
	
	$scope.addBlog=function()
	{
		console.log('Adding  blog information');
		$scope.blog.likes=0;
		$scope.blog.status='NA';
		$http.post('http://localhost:8082/ChatMiddleware/addBlog',$scope.blog)
			.then(function(response)
				{
					console.log("Blog creation is Succesful");
					console.log(response.statusText);
					$location.path("/blog");
				});
	}
	
//it is called from ApproveBlog.html for approving blog having NA status
	$scope.apprBlog=function(id)
	{
		console.log('inside approveBlog ');
		$http.get(url+'/approvedBlog/'+id)
		 .then(function(response)
				 {
			 		console.log(response.data);
				 });
		
		$location.path("/approveblog");
	}
	
	// for deleteing  a blog having status as NA
	$scope.deleteBlog=function(id)
	{
		console.log('inside deleteBlog ');
		$http.get(url+'deleteBlog/'+id)
		 .then(function(response)
				 {
			 		console.log(response.data);
				 });
		
		$location.path("/approveblog");
	}
	
//it is called by ShowBlogs.html to increase the no of like for a blog
	$scope.increaseLike=function(id)
	{
		console.log('inside increaseLike ');
		$http.get(url+'increamentLike/'+id)
		 .then(function(response)
				 {
			 		console.log(response.data);
			 		$location.path("/showblog");
				 });
		
		
	}
	
	function myBlog()
	{
		console.log('inside myBlog()');
		$http.get(url+'showMyBlog')
			.then(function(response)
				{
					console.log(response.data);
					$scope.blogdata=response.data;
				});
	}
	
	myBlog(); 
	
	function showAllBlog()
	{
		console.log('inside showBlog()');
		$http.get(url+'showAllBlog')
			.then(function(response)
				{
					console.log(response.data);
					$scope.showBlogData=response.data;
				});
	}
	
	showAllBlog(); 
	
	function showNotapproveBlog()
	{
		console.log('inside showNotapproveBlog()');
		$http.get(url+'showNotApprovedBlog')
			.then(function(response)
			{
				console.log(response.data);
				$scope.showNBlog=response.data;
			});
	}
	
	showNotapproveBlog();
	

	$scope.addBlogComment=function()
	{
		console.log('Adding  blog Comment');
		$scope.blogComment.loginName=$rootScope.currentUser.loginName;
		$scope.blogComment.blogId=$rootScope.blogId;
		console.log($scope.blogComment);
		$http.post(url+'/addComment',$scope.blogComment)
			.then(function(response)
				{
					console.log("Blog Comment is Added");
					console.log(response.statusText);
					$location.path("/blogcomment");
				});
	}
	
	
	$scope.listBlogComment=function(Id)
	{
		console.log('within listBlogComment()..');
		console.log('id = '+Id);
		$scope.blogComment.blogId=Id;
		$rootScope.blogId=Id;
		$http.get(url+'listAllBlogComment/'+Id)
			.then(function successCallback(response)
					{
						console.log(response.data);
						$rootScope.blogCommentData=response.data;
						
						console.log($rootScope.blogId=Id);
						console.log($rootScope.blogCommentData);
						$location.path("/blogcomment");
					},
					function errorCallback(response) 
					{
						$location.path("/blogcomment");
					});
	}
	
	
 });