package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

@RestController
public class ForumController 
{
	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping("/forumTest")
	public ResponseEntity<String>demo()
	{
		return new ResponseEntity<String>("Forum Controller is working",HttpStatus.OK);
		
	}
	

	@GetMapping("/showApprovedForum")
	public ResponseEntity<List<Forum>> showApprovedForum()
	{
		List<Forum> listForums=forumDAO.listApproveForums("user1");
		
		if(listForums!=null)
		{
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setLikes(0);
		forum.setLoginName("madhu");
		forum.setStatus("NA");
		
		System.out.println("Forum Name"+forum.getForumName());
		System.out.println("Forum Contents"+forum.getForumContent());
		
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Forum Addition Problem",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/approvedForum/{forumId}")
	public ResponseEntity<String> approvedForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forum!=null)
		{
		String frmName=forum.getForumName();
		if(forumDAO.approveForum(forum))
		{
			return new ResponseEntity<String>(frmName+" Forum is Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Forum",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Forum",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forum !=null)
		{
			String frmName=forum.getForumName();
		if(forumDAO.rejectForum(forum))
		{
			return new ResponseEntity<String>(frmName+" Forum is Rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forum!=null)
		{
		String frmName=forum.getForumName();
		if(forumDAO.deleteForum(forumId))
		{
			return new ResponseEntity<String>(frmName+" Forum is deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/increamentForumLike/{forumId}")
	public ResponseEntity<String> increamentLikeForForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forum!=null)
		{
		String frmName=forum.getForumName();
		if(forumDAO.increaseLike(forum))
		{
			return new ResponseEntity<String>(" Likes gets increamented for "+frmName,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Forum details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("getAForum/{forumId}")
	public ResponseEntity<Forum>getAForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forum!=null)
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Forum>(forum,HttpStatus.NOT_FOUND);
		}
	}
	
}
