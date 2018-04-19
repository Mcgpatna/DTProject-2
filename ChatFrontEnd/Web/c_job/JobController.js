myApp.controller("JobController",function($scope,$rootScope,$location,$http)
{
	var url='http://localhost:8082/ChatMiddleware/';
	
	$scope.job={jobId:0,jobDescription:'',jobDesignation:'',company:'',location:'',salary:0,lastDateApply:''};
	
	$scope.allJobData;
	
	$scope.addJob=function()
	{
		console.log("inside addJob()..");
		console.log($scope.job);
		$http.post(url+'addJob',$scope.job)
			.then(function(response)
					{
						console.log(response.statusCode);
					})
	}
	
	$scope.deleteJob=function()
	{
		console.log("inside deleteJob()..");
		
	}
	function listJob()
	{
		$http.get(url+'showAllJob')
		.then(function(response)
				{
					console.log('inside showjob function');
					$scope.allJobData=response.data;
					console.log($scope.allJobData);
				})
		
	}
	listJob();
});