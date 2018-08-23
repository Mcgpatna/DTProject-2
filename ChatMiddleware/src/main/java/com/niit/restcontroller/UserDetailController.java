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
					
		user.setRole("USER"); //role will be USER or ADMIN
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
	
	
	
	@PostMapping(value="/chkLogin")
	public ResponseEntity<UserDetail> chkLogin(@RequestBody UserDetail userDetail,HttpSession session)
	{
		
		if(userDAO.chkCredential(userDetail))
		{
			UserDetail tempUser=userDAO.getUser(userDetail.getLoginName());
			session.setAttribute("userDetail", tempUser);
			return new ResponseEntity<UserDetail>(tempUser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping(value="/chkDuplicateLogin")
	public ResponseEntity<Boolean> chkDuplicateLogin(@RequestBody String loginName,HttpSession session)
	{
		
		if(userDAO.chkDuplicateLogin(loginName))
		{
			session.setAttribute("userExist", "duplicate");
			return new ResponseEntity<Boolean>(true,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			session.setAttribute("userExist", "unique");
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}
	}
}
