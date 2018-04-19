package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;
import com.niit.model.BlogComment;



public interface BlogDAO {
	
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(int blogId);
	public boolean updateBlog(Blog blog);
	public List<Blog> listMyBlogs(String username);
	public boolean approveBolg(Blog blog);
	public boolean rejectBolg(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> listAllApprovedBlogs();
	public List<Blog> listAllNotApprovedBlogs();
	//public List<Blog> listMyBlogs(String username);
	public boolean increaseLike(Blog blog);
	
	//for BlogComment model class
	
	public boolean addBlogComment(BlogComment blogComment);
	public boolean deleteBlogComment(BlogComment blogComment);
	public BlogComment getBolgComment(int commentId);
	public List<BlogComment> listBlogComments(int blogId);
}
