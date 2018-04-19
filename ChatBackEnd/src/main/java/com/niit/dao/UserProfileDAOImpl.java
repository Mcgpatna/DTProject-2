package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.UserProfile;

@Repository("userProfileDAO")
public class UserProfileDAOImpl implements UserProfileDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(UserProfile userProfile) 
	{
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(userProfile);
		session.flush();
		session.close();
	}

	public UserProfile getProfilePicture(String username) 
	{
		Session session=sessionFactory.openSession();
		UserProfile profilePicture=(UserProfile)session.get(UserProfile.class, username);
		session.close();
		return profilePicture;
	}

}
