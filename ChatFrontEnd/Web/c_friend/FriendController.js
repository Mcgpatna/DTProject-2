myApp.controller("FriendController",function($http,$scope,$rootScope,$location)
{
	$scope.friend={friendId:0,loginName:'',friendLoginName:'',status:''};
	$scope.friendList;
	$scope.pendingFriendList;
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log(' inside showFriendList()..');
		$http.get('http://localhost:8082/ChatMiddleware/listOfFriend')
			.then(function(response)
					{
						$scope.friendList=response.data;
						console.log($scope.friendList);
						
					});
	}
	
	function showPendingFriendList()
	{
		console.log(' inside showPendingFriendList()..');
		$http.get('http://localhost:8082/ChatMiddleware/listOfPendingFriend')
			.then(function(response)
					{
						$scope.pendingFriendList=response.data;
						console.log($scope.pendingFriendList);
					});
	}
	
	function showSuggestedFriendList()
	{
		console.log(' inside showSuggestedFriendList()..');
		$http.get('http://localhost:8082/ChatMiddleware/suggestedFriend')
			.then(function(response)
					{
						$scope.suggestedFriendList=response.data;
						console.log($scope.suggestedFriendList);
					});
	}
	
	showFriendList();
	showPendingFriendList();
	showSuggestedFriendList();
	
	$scope.deleteFriend=function(friendId)
	{
		console.log('inside deleteFriend() ...')
		$http.get('http://localhost:8082/ChatMiddleware/deleteFriendRequest/'+friendId)
		.then(function(response)
				{
					console.log(response.statusText);
					$location.path("/showFriend");
				});
			
	}
	
	$scope.acceptFriend=function(friendId)
	{
		console.log('inside acceptFriend() ... with friend id'+friendId);
		
		$http.get('http://localhost:8082/ChatMiddleware/acceptFriendRequest/'+friendId)
		.then(function(response)
				{
					console.log(response.statusText);
					$location.path("/showPendingFriend");
				});
		

	}
	$scope.sendFriendRequest=function(loginname)
	{
		console.log('inside sendFriendRequest() ...');
		$scope.friend.loginName=loginname;
		$scope.friend.friendLoginName=$rootScope.currentUser.loginName;
		$scope.friend.status='P';
		
		$http.post('http://localhost:8082/ChatMiddleware/sendFriendRequest',$scope.friend)
		.then(function(response)
				{
					console.log(response.statusText);
					$location.path("/showSuggestedFriend");
				});
	}
	
});