myApp.controller("BlogController",function($scope,$rootScope,$location,$http,$cookieStore)
 {
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',likes:0,loginName:'',status:''};
	
	console.log($scope.blog);
	$scope.blogdata;
	$scope.showBlogData;
	$scope.showNBlog;
	
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
	

	$scope.apprBlog=function(id)
	{
		console.log('inside approveBlog ');
		$http.get(url+'/approvedBlog/'+id)
		 .then(function(response)
				 {
			 		console.log(response.data);
				 });
		
		$location.path("/showblog");
	}
	
	function listBlog()
	{
		console.log('inside listBlog()');
		$http.get(url+'showApprovedBlog')
			.then(function(response)
				{
					console.log(response.data);
					$scope.blogdata=response.data;
				});
	}
	
	listBlog(); 
	
	function showBlog()
	{
		console.log('inside showBlog()');
		$http.get(url+'showAllBlog')
			.then(function(response)
				{
					console.log(response.data);
					$scope.showBlogData=response.data;
				});
	}
	
	showBlog(); 
	
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
	
 });