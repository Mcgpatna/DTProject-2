package com.niit.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDAO;
import com.niit.model.Job;
import com.niit.model.JobApplyDetails;
import com.niit.model.UserDetail;

@RestController
public class JobController 
{
	@Autowired
	JobDAO jobDAO;
	
	@PostMapping("/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		System.out.println(job.getJobDescription());
		System.out.println("Last date to Apply "+job.getLastDateApply());
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("Jod details added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in inserting Jod details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showAllJob")
	public ResponseEntity<List<Job>> showAllJob()
	{
		
		List<Job> jobList=jobDAO.listtAllJobs();
		
		if(jobList !=null)
		{
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(jobList,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/deleteJob/{jobId}")
	public ResponseEntity<String> deleteJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobDAO.getJob(jobId);
		if(job!=null)
		{
			jobDAO.deleteJob(jobId);
			return new ResponseEntity<String>("Job details is deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Job details not Found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/applyJob")
	public ResponseEntity<String> applyJob(@RequestBody JobApplyDetails jobApply,HttpSession session)
	{
		
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		jobApply.setApplyDate(new Date());
		System.out.println(jobApply.getJobId());
		System.out.println("login name:"+userDetail.getLoginName());
		//jobApply.setJobId(job.getJobId());
		jobApply.setUserName(userDetail.getLoginName());
		
		System.out.println("user name is "+jobApply.getUserName()+" applydate is "+jobApply.getApplyDate());
		
		if(jobDAO.applyJob(jobApply))
		{
			return new ResponseEntity<String>("Jod apply added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in inserting Jod apply details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
