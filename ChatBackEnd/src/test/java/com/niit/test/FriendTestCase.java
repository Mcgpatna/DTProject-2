package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.UserDetail;


public class FriendTestCase 
{

	static FriendDAO friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		      
				AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
				context.refresh();
				
				friendDAO = (FriendDAO)context.getBean("friendDAO");
				System.out.println(" We are inside Before Class intantiated object!!"+friendDAO);
			    //Category category=(Category)context.getBean("category");
	}
	
	@Ignore
	@Test
	public void sendFriendRequestTest()
	{
		Friend friend=new Friend();
		friend.setLoginName("rajesh");
		friend.setFriendLoginName("user3");
		friend.setStatus("P");
		assertTrue("Problem in sending friend Request..",friendDAO.sendFriendRequest(friend));
		
	}
	
	@Ignore
	@Test
	public void acceptFriendRequestTest()
	{
		assertTrue("Problem in accepting Friend Request",friendDAO.acceptFriendRequest(954));
	}
	
	@Ignore
	@Test
	public void deleteFriendRequestTest()
	{
		assertTrue("Problem in deleting Friend Request",friendDAO.deleteFriendRequest(955));
	}
	
	@Ignore
	@Test
	public void suggestedFriendRequest()
	{
		List<UserDetail> listUserDetail=friendDAO.showSuggestedFriend("rajesh");
		
		assertTrue("Problem in listing user detail",listUserDetail.size()>0);
		
		for(UserDetail user:listUserDetail)
		{
			System.out.println("Login Name:"+user.getLoginName());
		}
	}
	
	@Ignore
	@Test
	public void showFriendListTest()
	{
		List<Friend> listFriend=friendDAO.showFriendList("user2");
		
		assertTrue("Problem in listing friend",listFriend.size()>0);
		
		for(Friend friend:listFriend)
		{
			System.out.println("Login name :"+friend.getLoginName()+" Friend's Name:"+friend.getFriendLoginName());
		}
	}

	@Test
	public void showPendingRequestTest()
	{
		List<Friend> listFriend=friendDAO.showPendingFriendRequest("user2");
		
		assertTrue("Problem in listing friend",listFriend.size()>0);
		
		for(Friend friend:listFriend)
		{
			System.out.println("Login name :"+friend.getLoginName()+" Friend's Name:"+friend.getFriendLoginName());
		}
	}
}
