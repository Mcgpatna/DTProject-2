package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addJob(Job job) 
	{
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} 
		catch (Exception e) 
		{
			
			System.out.println("Error in insert.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(int jobId) 
	{
		try {
			Job job=(Job)sessionFactory.getCurrentSession().get(Job.class,jobId);
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in deleteion.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) 
	{
		try 
		{
			
			sessionFactory.getCurrentSession().update(job);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in Updation.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public List<Job> listtAllJobs() 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			
			List<Job> listJobs=query.list();
			return listJobs;
		} 
		catch (Exception e) {
			
			System.out.println("Error in getting all Jobs.. "+e);
			
			return null;
		}
	}

	public Job getJob(int jobId) 
	{
		
		try 
		{
			Session session=sessionFactory.openSession();
			Job job=(Job)session.get(Job.class, jobId);
			
			return job;
		} 
		catch (Exception e) 
		{
			
			System.out.println("Error in getting job.. "+e);
			return null;
		}
	}
	
	public boolean applyJob(int jobId)
	{
		
		return true;
	}
	

}
