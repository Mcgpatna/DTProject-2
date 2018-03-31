package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.UserDetail;

@Repository("userDetailDAO")
public class UserDetailDAOImpl implements UserDetailDAO
{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addUserDetail(UserDetail user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		} 
		catch (Exception e) 
		{
			
			System.out.println("Error in insert user.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateUserDetail(UserDetail user) 
	{
		try 
		{
			
			sessionFactory.getCurrentSession().update(user);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in Updation.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public List<UserDetail> listUsers(String loginName) 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			System.out.println("username is " +loginName);
			Query query=session.createQuery("from UserDetail where loginname=:loginName");
			query.setParameter("loginName", loginName);
			List<UserDetail> listUsers=query.list();
			return listUsers;
		} 
		catch (Exception e) {
			
			System.out.println("Error in a particular User.. "+e);
			
			return null;
		}
	}

	public List<UserDetail> listAllUsers() 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			
			Query query=session.createQuery("from UserDetail");
			
			List<UserDetail> listUsers=query.list();
			return listUsers;
		} 
		catch (Exception e) {
			
			System.out.println("Error in a all Users.. "+e);
			
			return null;
		}
	}

}
