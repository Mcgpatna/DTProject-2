myApp.controller("UserController",function($scope,$rootScope,$http,$location)
{
	$scope.User={loginName:'',password:'',userName:'',emailId:'',mobileNo:'',address:'',status:'',role:''};
	
	$scope.register=function()
	{
		console.log('Inside the register function of UserController.js');
		
		$scope.User.role='USER';
		$scope.User.status='A';
		
		$http.post('http://localhost:8082/ChatMiddleware/addUser',$scope.User)
			.then(function(response)
				{
					console.log('Registration is Successful');
					console.log(response.statusText);
					$location.path("/login");
				});
	}
	
	$scope.login=function()
	{
		console.log('Inside the login() of Usercontroller.js');
		$http.post('http://localhost:8082/ChatMiddleware/chkLogin',$scope.User)
			.then(function(response)
				{
					$scope.User=response.data;
					$rootScope.currentUser=response.data;
					console.log($rootScope.currentUser);
					$location.path("/UserHome");
				})
		
	}
});