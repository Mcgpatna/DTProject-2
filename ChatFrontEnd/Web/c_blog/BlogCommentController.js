/*myApp.controller("BlogController",function($scope,$rootScope,$location,$http)
 {
	$scope.blogComment={commentId:0,commentTest:'',loginname:'',blogId:0,commentDate:''};
	
	
	var url='http://localhost:8082/ChatMiddleware/';
	
	$scope.addBlogComment=function()
	{
		console.log('Adding  blog Comment');
		$scope.blogComment.loginname=currentUser.loginname;
		$scope.blogComment.blogId=$rootScope.blogId;
		
		$http.post(url+'/addComment',$scope.blog)
			.then(function(response)
				{
					console.log("Blog Comment is Added");
					console.log(response.statusText);
					$location.path("/blogcomment");
				});
	}
	

	function listBlogComment()
	{
		console.log('within listBlogComment()..');
		$http.get(url+'/listAllBlogComment/'+$rootScope.blogId)
			.then(function(response)
					{
						$rootScope.blogCommentData=response.data;
						$rootScope.blogId=blogId;
						console.log($rootScope.blogCommentData);
						$location.path("/blogcomment");
					});
	}
	
	listBlogComment();
 });*/