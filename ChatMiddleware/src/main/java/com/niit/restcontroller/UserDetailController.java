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

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

@RestController
public class UserDetailController 
{
	@Autowired
	UserDetailDAO userDAO;
	
	@GetMapping("/userTest")
	public ResponseEntity<String>demo()
	{
		return new ResponseEntity<String>("UserDetail Controller is working",HttpStatus.OK);
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserDetail user)
	{
					
		user.setRole("USER");
		user.setStatus("A");
		
		System.out.println("Role of User is "+user.getRole());
		System.out.println("Status of User is "+user.getStatus());
		
		if(userDAO.addUserDetail(user))
		{
			return new ResponseEntity<String>("User details are added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in adding User's detail",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listAllUser")
	public ResponseEntity<List<UserDetail>> showAllUser()
	{
		List<UserDetail> listUser=userDAO.listAllUsers();
		
		if(listUser!=null)
		{
			return new ResponseEntity<List<UserDetail>>(listUser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(listUser,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/listAUser/{loginName}")
	public ResponseEntity<List<UserDetail>> showSingleUser(@PathVariable("loginName")String loginName)
	{
		List<UserDetail> listUser=userDAO.listUsers(loginName);
		
		if(listUser!=null)
		{
			return new ResponseEntity<List<UserDetail>>(listUser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(listUser,HttpStatus.NOT_FOUND);
		}
		
	}
}
