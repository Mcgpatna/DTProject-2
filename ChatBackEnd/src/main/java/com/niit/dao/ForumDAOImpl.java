package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ForumComment;
import com.niit.model.ForumComment;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
import com.niit.model.Forum;
import com.niit.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addForum(Forum forum) 
	{
		try {
			sessionFactory.getCurrentSession().save(forum);
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
	public boolean deleteForum(int forumId) 
	{
		try {
			Forum forum=(Forum)sessionFactory.getCurrentSession().get(Forum.class,forumId);
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in deleteion.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateForum(Forum forum) 
	{
		
		try 
		{
			
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in Updation.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public List<Forum> listForums(String username) 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			System.out.println("username is " +username);
			Query query=session.createQuery("from Forum where loginname=:username");
			query.setParameter("username", username);
			List<Forum> listForums=query.list();
			return listForums;
		} 
		catch (Exception e) {
			
			System.out.println("Error in a particular Forum.. "+e);
			
			return null;
		}
	}
	
	@Transactional
	public boolean approveForum(Forum forum) 
	{
		try 
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in updating Status.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean rejectForum(Forum forum) 
	{
		try 
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in rejecting forum .. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public Forum getForum(int forumId) 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Forum forum=(Forum)session.get(Forum.class, forumId);
			
			return forum;
		} 
		catch (Exception e) 
		{
			
			System.out.println("Error in getting forum.. "+e);
			return null;
		}
	}

	public List<Forum> listAllForums() 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Forum");
			
			List<Forum> listForums=query.list();
			return listForums;
		} 
		catch (Exception e) {
			
			System.out.println("Error in all Forums.. "+e);
			
			return null;
		}
	}

	@Transactional
	public boolean increaseLike(Forum forum) 
	{
		try
		{
			int ctr=forum.getLikes();
			ctr++;
			forum.setLikes(ctr);
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in updating likes..."+e);
			return false;
		
		}
	}

	@Transactional
	public boolean addForumComment(ForumComment forumComment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("error in inserting Comment..."+e);
			return false;
		}
	}

	@Transactional
	public boolean deleteForumComment(ForumComment forumComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("error in inserting Comment..."+e);
			return false;
		}
	}

	public ForumComment getBolgComment(int commentId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			ForumComment forum=(ForumComment)session.get(ForumComment.class, commentId);
			return forum;
		}
		catch(Exception e)
		{
			System.out.println("error in getting Comment..."+e);
			return null;
		}
	}

	public List<ForumComment> listForumComments(int forumId) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId",forumId);
		List <ForumComment> listForumComments=query.list();
		return listForumComments;
	}

}
