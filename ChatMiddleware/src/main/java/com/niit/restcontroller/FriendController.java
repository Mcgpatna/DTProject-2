package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDAO;
import com.niit.model.Friend;
import com.niit.model.UserDetail;

@RestController
public class FriendController 
{

	@Autowired
	FriendDAO friendDAO;
	
	@PostMapping(value="/sendFriendRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Request Accepted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Request is not Accepted",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/suggestedFriend")
	public ResponseEntity<List<UserDetail>> suggestedFriend(HttpSession session)
	{
		String username=((UserDetail)session.getAttribute("userDetail")).getLoginName();
		List<UserDetail> listUsers=friendDAO.showSuggestedFriend(username);
		
		if(listUsers.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(listUsers,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(listUsers,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/listOfFriend")
	public ResponseEntity<List<Friend>> listOfFriend(HttpSession session)
	{
		String username=((UserDetail)session.getAttribute("userDetail")).getLoginName();
		List<Friend> listOfFriend=friendDAO.showFriendList(username);
		
		if(listOfFriend.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listOfFriend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listOfFriend,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/listOfPendingFriend")
	public ResponseEntity<List<Friend>> listOfPendingFriend(HttpSession session)
	{
		String username=((UserDetail)session.getAttribute("userDetail")).getLoginName();
		List<Friend> listOfPendingFriend=friendDAO.showPendingFriendRequest(username);
		
		if(listOfPendingFriend.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listOfPendingFriend,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listOfPendingFriend,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId") int friendId)
	{
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Success",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId") int friendId)
	{
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Success",HttpStatus.NOT_FOUND);
		}
	}
}
