package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="friendidseq",sequenceName="myfriend_seq")
public class Friend 
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendidseq")
	int friendId;
	
	String loginName;
	String friendLoginName;
	String status;
	
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getFriendLoginName() {
		return friendLoginName;
	}
	public void setFriendLoginName(String friendLoginName) {
		this.friendLoginName = friendLoginName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
