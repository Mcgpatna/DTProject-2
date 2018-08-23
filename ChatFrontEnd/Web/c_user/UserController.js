myApp.controller("UserController",function($scope,$rootScope,$http,$location,$cookieStore)
{
	$scope.User={loginName:'',password:'',userName:'',emailId:'',mobileNo:'',address:'',status:'',role:''};
	$scope.profile={loginName:'',image:''};
	
	$rootScope.userNameExist;
	
	$scope.registered=function()
	{
		console.log('Inside the register function of UserController.js');
		
		$scope.User.role='USER';
		$scope.User.status='A';
		
		$http.post('http://localhost:8082/ChatMiddleware/addUser',$scope.User)
			.then(function(response)
				{
					console.log('Registration is Successful');
					console.log(response.statusText);
					
					$location.path('ChatFrontEnd/login');
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
					$cookieStore.put('userDetail',response.data);
					$rootScope.userNameExist=true;
					$location.path("/UserHome");
				},
				function(error)
				  {
					  console.log(error.data);
					  console.log("Either User Name or Password is Incorrect");  
					  $rootScope.userNameExist=false;
				  });
		
	}
	//checking for duplicate login name
	$scope.chkDuplicateLogin=function()
	{
		 console.log('Inside chkDuplicateLogin() ...');
		 $http.post('http://localhost:8082/ChatMiddleware/chkDuplicateLogin',$scope.User.loginName)
		  .then(function(response)
				  {
			  		
			  		console.log(response.data);
			  		console.log("User Name is Unique");
			  		$rootScope.userNameExist=false;
				  },
				  function(error)
				  {
					  console.log(error.data);
					  console.log("User Name is already Taken");  
					  $rootScope.userNameExist=true;
				  });
		 
	}
	
	
	$scope.doUpload=function()
	{
		console.log('inside doUpload()..');
		$http.post('http://localhost:8082/ChatMiddleware/doUpload',$scope.profile)
		.then(function(response)
				{
					console.log(response.data);
					$location.path("/");
				});
	}
	
	$rootScope.logout=function()
	{
		console.log("location is " +$location.path());
		console.log("logout successfully......");
		
		$cookieStore.remove('userDetail');
		delete $rootScope.currentUser;
		$rootScope.message = "Logout successfully!";
		
	    $location.path('ChatFrontEnd/login');
	}
});