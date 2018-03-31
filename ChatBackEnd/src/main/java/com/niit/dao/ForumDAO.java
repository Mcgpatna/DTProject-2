package com.niit.dao;

import java.util.List;

import com.niit.model.Forum;
import com.niit.model.ForumComment;


public interface ForumDAO 
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(int forumId);
	public boolean updateForum(Forum forum);
	public List<Forum> listForums(String username);
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> listAllForums();
	public boolean increaseLike(Forum forum);
	
	//for ForumComment model class
	
	public boolean addForumComment(ForumComment forumComment);
	public boolean deleteForumComment(ForumComment forumComment);
	public ForumComment getBolgComment(int commentId);
	public List<ForumComment> listForumComments(int forumId);
}
