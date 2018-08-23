package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friend;
import com.niit.model.UserDetail;

public class FriendDAOImpl implements FriendDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	

	public List<Friend> showFriendList(String loginname) 
	{
	
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Friend where friendLoginName=:myloginname and status='A'");
			query.setParameter("myloginname", loginname);
			//query.setParameter("floginname", loginname);
			List<Friend> listFriends=(List<Friend>)query.list();
			return listFriends;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Friend> showPendingFriendRequest(String loginname) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Friend where loginName=:myloginname and status='P'");
			query.setParameter("myloginname", loginname);
			
			List<Friend> listFriends=(List<Friend>)query.list();
			return listFriends;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<UserDetail> showSuggestedFriend(String loginname) 
	{
	
		Session session=sessionFactory.openSession();
		SQLQuery sqlQuery=session.createSQLQuery("select loginName from UserDetail where loginName not in(select loginName from Friend where friendLoginName='"+loginname+"') and loginName !='"+loginname+"'");
		List<String> listUsers=(List<String>) sqlQuery.list();
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<listUsers.size())
		{
			UserDetail userDetail=session.get(UserDetail.class, listUsers.get(i));
			listUserDetail.add(userDetail);
			i++;
		}
		return listUserDetail;
	}

	@Transactional
	public boolean sendFriendRequest(Friend friend) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			System.out.println("inside sendFriendRequest()..");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean acceptFriendRequest(int friendId) 
	{
	
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend =session.get(Friend.class, friendId);
			friend.setStatus("A");
			session.update(friend);
			System.out.println("Updated..\n"+"Login Name:"+friend.getLoginName());
			session.flush();
			Friend fr1=new Friend();
			String nm=friend.getFriendLoginName();
			String fnm=friend.getLoginName();
			fr1.setFriendLoginName(fnm);
			fr1.setLoginName(nm);
			fr1.setStatus("A");
			session.save(fr1);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Transactional
	public boolean deleteFriendRequest(int friendId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend =session.get(Friend.class, friendId);
			
			session.delete(friend);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	
}
