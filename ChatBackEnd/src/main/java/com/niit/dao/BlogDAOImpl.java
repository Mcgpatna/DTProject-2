package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	//@Override
	public boolean addBlog(Blog blog)
	{
		try {
			sessionFactory.getCurrentSession().save(blog);
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
	//@Override
	public boolean deleteBlog(int blogId) 
	{
	
		try {
			Blog blog=(Blog)sessionFactory.getCurrentSession().get(Blog.class,blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in deleteion.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	//@Override
	public boolean updateBlog(Blog blog) 
	{
		try 
		{
			
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in Updation.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public List<Blog> listMyBlogs(String username) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Session session=sessionFactory.openSession();
			System.out.println("username is " +username);
			Query query=session.createQuery("from Blog where loginname=:username");
			query.setParameter("username", username);
			List<Blog> listBlogs=query.list();
			return listBlogs;
		} 
		catch (Exception e) {
			
			System.out.println("Error in a particular Blog.. "+e);
			
			return null;
		}
	}
	
	/*public List<Blog> listApprovedBlogs(String username) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Session session=sessionFactory.openSession();
			System.out.println("username is " +username);
			Query query=session.createQuery("from Blog where loginname=:username and status='A'");
			query.setParameter("username", username);
			List<Blog> listBlogs=query.list();
			return listBlogs;
		} 
		catch (Exception e) {
			
			System.out.println("Error in a particular Blog.. "+e);
			
			return null;
		}
	}*/

	@Transactional
	public boolean approveBolg(Blog blog) 
	{
		
		try 
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in updating Status.. "+e);
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean rejectBolg(Blog blog) 
	{
		try 
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} 
		catch (Exception e) {
			
			System.out.println("Error in rejecting blog .. "+e);
			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlog(int blogId) 
	{
		
		try 
		{
			Session session=sessionFactory.openSession();
			Blog blog=(Blog)session.get(Blog.class, blogId);
			
			return blog;
		} 
		catch (Exception e) 
		{
			
			System.out.println("Error in getting blog.. "+e);
			return null;
		}
	}

	public List<Blog> listAllApprovedBlogs() 
	{
		
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog where status='A'");
			
			List<Blog> listBlogs=query.list();
			return listBlogs;
		} 
		catch (Exception e) {
			
			System.out.println("Error in all Blogs.. "+e);
			
			return null;
		}
	}

	public List<Blog> listAllNotApprovedBlogs() 
	{
		
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog where status='NA'");
			
			List<Blog> listBlogs=query.list();
			return listBlogs;
		} 
		catch (Exception e) {
			
			System.out.println("Error in all Blogs.. "+e);
			
			return null;
		}
	}

	@Transactional
	public boolean increaseLike(Blog blog) 
	{
		try
		{
			int ctr=blog.getLikes();
			ctr++;
			blog.setLikes(ctr);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in updating likes..."+e);
			return false;
		
		}
	}

	@Transactional
	public boolean addBlogComment(BlogComment blogComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("error in inserting Comment..."+e);
			return false;
		}
	}

	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) 
	{

		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("error in inserting Comment..."+e);
			return false;
		}

	}

	public BlogComment getBolgComment(int commentId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			BlogComment blog=(BlogComment)session.get(BlogComment.class, commentId);
			return blog;
		}
		catch(Exception e)
		{
			System.out.println("error in getting Comment..."+e);
			return null;
		}
		
	}

	public List<BlogComment> listBlogComments(int blogId) 
	{
		Session session=sessionFactory.openSession();
		System.out.println("blog id is "+blogId);
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId",blogId);
		List <BlogComment> listBlogComments=query.list();
		for(BlogComment comment:listBlogComments)
		{
			System.out.println("id :"+comment.getBlogId()+"::"+comment.getLoginName()+"::"+comment.getCommentText());
		}
		return listBlogComments;
	}
	
	

}
