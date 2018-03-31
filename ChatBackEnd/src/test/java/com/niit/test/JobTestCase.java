package com.niit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDAO;

import com.niit.model.Job;

public class JobTestCase 
{

	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				jobDAO=(JobDAO)context.getBean("jobDAO");
				
				System.out.println(" We are inside Before Class intantiated object!!"+jobDAO);
			  
	}
	
	@Ignore
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		
		job.setJobDescription("Software Developer in Java Technology");
		job.setCompany("Infosys");
		job.setJobDesignation("Project Leader");
		job.setLocation("Pune");
		Date dt=new Date(2018,05,20);
		
		job.setLastDateApply(dt);
		job.setSalary(12000);
		
		assertTrue("Problem in insert job... ",jobDAO.addJob(job));
	}
	
	@Test
	public void listAllJobTestCase()
	{
		List <Job> listJob=jobDAO.listtAllJobs();
		for(Job job:listJob)
		{
			System.out.print(job.getJobDescription()+":::");
			System.out.print(job.getJobDesignation()+":::");
			System.out.print(job.getCompany()+":::");
			System.out.print(job.getSalary()+":::");
			System.out.print(job.getLocation());
			
		}
	}
	
	@Ignore
	@Test
	public void deleteingJobTest()
	{
		assertTrue("Problem in Job Deletion..",jobDAO.deleteJob(952));
	}
	
	@Test
	public void updatingJobTest()
	{
		Job job=jobDAO.getJob(952);
		Date dt=job.getLastDateApply();
		int mm=dt.getMonth()+1;
		System.out.println("month = "+mm);
		Date dt1=new Date(2018,mm+1,20);
		job.setLastDateApply(dt1);
		assertTrue("Problem in Job updation..",jobDAO.updateJob(job));
	}

}
