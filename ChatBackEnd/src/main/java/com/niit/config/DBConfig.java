package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDAO;
import com.niit.dao.BlogDAOImpl;
import com.niit.dao.ForumDAO;
import com.niit.dao.ForumDAOImpl;
import com.niit.dao.JobDAO;
import com.niit.dao.JobDAOImpl;
import com.niit.dao.UserDetailDAO;
import com.niit.dao.UserDetailDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Job;
import com.niit.model.UserDetail;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	
	
	public DataSource getDataSource()
	{
		System.out.println("inside getDataSource()....");
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		
		System.out.println("-------->  Data Source is now operational  <---------");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
			Properties hibernateProp = new Properties();
			
			hibernateProp.put("hibernate.hbm2ddl.auto","update");
			hibernateProp.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			
			LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource()); // This is data coming/pulled from H2 Database.(Talking about the parameter here!)
			
					
			sessionFactoryBuilder.addProperties(hibernateProp);  
			sessionFactoryBuilder.scanPackages("com.niit");
			sessionFactoryBuilder.addAnnotatedClass(Blog.class); 
			sessionFactoryBuilder.addAnnotatedClass(Forum.class);
			sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
			sessionFactoryBuilder.addAnnotatedClass(Job.class);
			
			SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
			System.out.println(" * * * * * Session Factory Bean or better to call 'the Spring Container' has just been initalized * * * * * ");
			 return sessionFactory;
	}

	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO()
	{
			System.out.println("+++++ Do database manipulation of Blog Model as BlogDAO has been enabled now!! +++++");
		    return new BlogDAOImpl();
	}
	
	@Bean(name="forumDAO")
	public ForumDAO getforumDAO()
	{
			System.out.println("+++++ Do database manipulation of Forum Model as ForumDAO has been enabled now!! +++++");
		    return new ForumDAOImpl();
	}
	
	@Bean(name="userDetailDAO")
	public UserDetailDAO getUserDetailDAO()
	{
			System.out.println("+++++ Do database manipulation of UserDetail Model as UserDetailDAO has been enabled now!! +++++");
		    return new UserDetailDAOImpl();
	}
	
	@Bean(name="jobDAO")
	public JobDAO getJobDAO()
	{
			System.out.println("+++++ Do database manipulation of Job Model as JobDAO has been enabled now!! +++++");
		    return new JobDAOImpl();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("(   (  ( (Transaction Tunnel has been opened for a Synchronized committed transaction with the Oracle Database) )  )   )");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
