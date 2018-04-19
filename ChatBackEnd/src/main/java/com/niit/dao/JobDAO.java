package com.niit.dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public boolean deleteJob(int jobId);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
	public List<Job> listtAllJobs();
	public boolean applyJob(int jobId);

}
