package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.niit.model.BlogComment;


public class BlogDAOTestCase {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	static BlogDAO blogDAO;
	

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
				blogDAO = (BlogDAO)context.getBean("blogDAO");
				System.out.println(" We are inside Before Class intantiated object!!"+blogDAO);
			    //Category category=(Category)context.getBean("category");
	}
	
	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogName("STrut Framework");
		blog.setBlogContent("Strut Framework  and its related Topics");
		blog.setLikes(0);
		blog.setLoginName("user1");
		blog.setStatus("NA");
		blog.setCreateDate(new java.util.Date());
		assertTrue("Problem in Blog Insert..",blogDAO.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void deleteingBlogTest()
	{
		assertTrue("Problem in Blog Deletion..",blogDAO.deleteBlog(1));
	}
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in Blog Rejection",blogDAO.rejectBolg(blog));
	}
	
	@Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in Blog Rejection",blogDAO.approveBolg(blog));
	}
	
	@Ignore
	@Test
	public void listBlogByUserTest()
	{
		List <Blog> listBlog=blogDAO.listMyBlogs("user1");
		assertTrue("Promlem in listing a Blog",listBlog.size()>0);
		
		for(Blog blog:listBlog)
		{
			System.out.print(blog.getBlogName()+":::");
			System.out.print(blog.getBlogContent()+":::");
			System.out.println(blog.getLoginName());
			
		}
	}
	
	@Ignore
	@Test
	public void listNotApprovedBlogByUserTest()
	{
		List <Blog> listBlog=blogDAO.listAllNotApprovedBlogs();
		assertTrue("Promlem in listing a Blog",listBlog.size()>0);
		
		for(Blog blog:listBlog)
		{
			System.out.print(blog.getBlogName()+":::");
			System.out.print(blog.getBlogContent()+":::");
			System.out.println(blog.getLoginName());
			
		}
	}
	
	@Ignore
	@Test
	public void increamentLikeTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Promlem in increamenting Likes",blogDAO.increaseLike(blog));
	}
	
	
	@Ignore
	@Test
	public void listAllBlogTestCase()
	{
		List <Blog> listBlog=blogDAO.listAllApprovedBlogs();
		for(Blog blog:listBlog)
		{
			System.out.print(blog.getBlogName()+":::");
			System.out.print(blog.getBlogContent()+":::");
			System.out.println(blog.getLoginName());
			
		}
	}
	
	//@Ignore
	@Test
	public void addCommentTest()
	{
		BlogComment comments=new BlogComment();
		comments.setCommentText("Very Informative");
		comments.setCommentDate(new java.util.Date());
		comments.setLoginName("madhu");
		comments.setBlogId(972);
		assertTrue("Problem in inserting comments..",blogDAO.addBlogComment(comments));
	}
	
	@Ignore
	@Test
	public void listAllBlogComment()
	{
		List<BlogComment> listComments=blogDAO.listBlogComments(953);
		assertTrue("Problem in listing comments..",listComments.size()>0);
		
		for(BlogComment blogComment:listComments)
		{
			System.out.print(blogComment.getBlogId()+":::");
			System.out.print(blogComment.getCommentText()+":::");
			System.out.println(blogComment.getLoginName());
		}
	}
	
	@Ignore
	@Test
	public void deleteingBlogCommentTest()
	{
		BlogComment blgComment=blogDAO.getBolgComment(953);
		assertTrue("Problem in Blog Deletion..",blogDAO.deleteBlogComment(blgComment));
	}
}
