
myApp.controller("JobController",function($scope,$rootScope,$location,$http)
{
	var url='http://localhost:8082/ChatMiddleware/';
	
	$scope.job={jobId:0,jobDescription:'',jobDesignation:'',company:'',location:'',salary:0,lastDateApply:''};
	$scope.jobApply={jobApplyId:0,jobId:0,userName:'',applyDate:''};
	
	
	$scope.allJobData;
	
	$scope.addJob=function()
	{
		console.log("inside addJob()..");
		console.log($scope.job);
		
		
		
		console.log($scope.job.lastDateApply);
		$http.post(url+'addJob',$scope.job)
			.then(function(response)
					{
						console.log(response.statusCode);
						$location.path('/showJob');
					});
	}
	
	$scope.deleteJob=function(id)
	{
		console.log("inside deleteJob()..id="+id);
		$http.get(url+'deleteJob/'+id)
		  .then(function(reponse)
				  {
			  		console.log(reponse.statusText)
			  		$location.path('/showJob');
				  });
	}
	
	$scope.applyJob=function(id)
	{
		console.log('inside applyJob() ...');
		$scope.jobApply.jobId=id;
		console.log($scope.jobApply);
		$http.post(url+'applyJob',$scope.jobApply)
		  .then(function(response)
				  {
			  		console.log(response.data);
			  		
				 });
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