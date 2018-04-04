package com.niit.dao;

import java.util.List;


import com.niit.model.UserDetail;

public interface UserDetailDAO 
{

	public boolean addUserDetail(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public UserDetail getUser(String loginName);
	public List<UserDetail> listAllUsers();
	public boolean chkCredential(UserDetail user);
}
