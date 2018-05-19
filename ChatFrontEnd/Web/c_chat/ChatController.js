myApp.controller('ChatController', function($scope,$rootScope,chatService)
{
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	$rootScope.username;
	
	$scope.addMessage=function()
	{
		$rootScope.username=$rootScope.currentUser.loginName;
		chatService.send($rootScope.currentUser.loginName+":" +$scope.message);
		$scope.message="";
	};

	chatService.receive().then(null,null,function(message)
	{
		$scope.messages.push(message);
	});	

});