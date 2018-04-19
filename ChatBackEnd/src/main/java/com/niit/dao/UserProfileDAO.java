package com.niit.dao;

import com.niit.model.UserProfile;

public interface UserProfileDAO 
{
	
	public void save(UserProfile userProfile);
	public UserProfile getProfilePicture(String username);

}
