package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDetailTestCase {

	static UserDetailDAO userDAO; 
	
	
	@BeforeClass
	public static void initialize()
	{
		       //Create the Spring Container class object (here it is 'context') to catch a specific tagged bean from its body//
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				// Here you use the Spring Container object to trap that bean method module with its @Bean tagged annotation name (i.e. 'categoryDAO') from DBConfig.java file//
				// Note that here the annotated code has not just instantiated the class but, initialized it's object by taking and assigning it, a whole class as a value in itself for testing//
				//CategoryDAO categoryDAO = (CategoryDAO)context.getBean("categoryDAO");	
				userDAO = (UserDetailDAO)context.getBean("userDetailDAO");
				System.out.println(" We are inside Before Class intantiated object!!"+userDAO);
			    //Category category=(Category)context.getBean("category");
	}

	@Ignore
	@Test
	public void addUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setLoginName("user1");
		user.setEmailId("user1@gmail.com");
		user.setAddress("Patna");
		user.setMobileNo("123456");
		user.setPassword("pass@123");
		user.setRole("USER");
		user.setStatus("A");
		user.setUserName("MadhuChanda Ghose");
		assertTrue("Problem in inserting user deatils..",userDAO.addUserDetail(user));
	}
	
	@Test
	public void listSingleUser()
	{
		List<UserDetail> list=userDAO.listUsers("madhu");
		
		assertTrue("Problem in listing user..",list.size()>0);
		
		for(UserDetail user:list)
		{
			System.out.print(user.getLoginName()+":::");
			System.out.println(user.getUserName());
			
		}
	}
	
	@Test
	public void listAllUser()
	{
		List<UserDetail> listUsers=userDAO.listAllUsers();
		
		for(UserDetail user:listUsers)
		{
			System.out.print(user.getLoginName()+":::");
			System.out.println(user.getUserName());
		}
	}
}
