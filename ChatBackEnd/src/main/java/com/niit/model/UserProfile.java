package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProfile 
{

	@Id
	private String loginName;
	private byte[] image;
	
	
	//getter and setter method
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
}
