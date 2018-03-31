package com.niit.dao;

import java.util.List;


import com.niit.model.UserDetail;

public interface UserDetailDAO 
{

	public boolean addUserDetail(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public List<UserDetail> listUsers(String loginName);
	public List<UserDetail> listAllUsers();
}
