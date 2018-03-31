package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;
import com.niit.model.ForumComment;
//import com.niit.model.ForumComment;


public class ForumDAOTestCase {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	static ForumDAO forumDAO;
	

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
				forumDAO = (ForumDAO)context.getBean("forumDAO");
				System.out.println(" We are inside Before Class intantiated object!!"+forumDAO);
			    //Category category=(Category)context.getBean("category");
	}
	
	@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		
		forum.setForumName("Andriod  Forum");
		forum.setForumContent("Android application and its related Topics");
		forum.setLikes(0);
		forum.setLoginName("user1");
		forum.setStatus("A");
		forum.setCreateDate(new java.util.Date());
		assertTrue("Problem in Forum Insert..",forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
	public void deleteingForumTest()
	{
		assertTrue("Problem in Forum Deletion..",forumDAO.deleteForum(1));
	}
	
	@Ignore
	@Test
	public void rejectForumTest()
	{
		Forum forum=forumDAO.getForum(952);
		assertTrue("Problem in Forum Rejection",forumDAO.rejectForum(forum));
	}
	
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=forumDAO.getForum(952);
		assertTrue("Problem in Forum Rejection",forumDAO.approveForum(forum));
	}
	
	@Ignore
	@Test
	public void listForumByUserTest()
	{
		List <Forum> listForum=forumDAO.listForums("user1");
		assertTrue("Promlem in listing a Forum",listForum.size()>0);
		
		for(Forum forum:listForum)
		{
			System.out.print(forum.getForumName()+":::");
			System.out.print(forum.getForumContent()+":::");
			System.out.println(forum.getLoginName());
			
		}
	}
	
	@Ignore
	@Test
	public void increamentLikeTest()
	{
		Forum forum=forumDAO.getForum(952);
		assertTrue("Promlem in increamenting Likes",forumDAO.increaseLike(forum));
	}
	
	
	@Ignore
	@Test
	public void listAllForumTestCase()
	{
		List <Forum> listForum=forumDAO.listAllForums();
		for(Forum forum:listForum)
		{
			System.out.print(forum.getForumName()+":::");
			System.out.print(forum.getForumContent()+":::");
			System.out.println(forum.getLoginName());
			
		}
	}
	
	@Ignore
	@Test
	public void addCommentTest()
	{
		ForumComment comments=new ForumComment();
		comments.setCommentText("Very Informative");
		comments.setCommentDate(new java.util.Date());
		comments.setLoginName("madhu");
		comments.setForumId(952);
		assertTrue("Problem in inserting comments..",forumDAO.addForumComment(comments));
	}
	
	//@Ignore
	@Test
	public void listAllForumComment()
	{
		List<ForumComment> listComments=forumDAO.listForumComments(952);
		assertTrue("Problem in listing comments..",listComments.size()>0);
		
		for(ForumComment forumComment:listComments)
		{
			System.out.print(forumComment.getForumId()+":::");
			System.out.print(forumComment.getCommentText()+":::");
			System.out.println(forumComment.getLoginName());
		}
	}
	
	@Ignore
	@Test
	public void deleteingForumCommentTest()
	{
		ForumComment blgComment=forumDAO.getBolgComment(953);
		assertTrue("Problem in Forum Deletion..",forumDAO.deleteForumComment(blgComment));
	}
}
