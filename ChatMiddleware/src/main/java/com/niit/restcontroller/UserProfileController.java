package com.niit.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.dao.UserProfileDAO;
import com.niit.model.UserDetail;
import com.niit.model.UserProfile;

@RestController
public class UserProfileController 
{
	@Autowired
	UserProfileDAO userProfileDAO;
	
	//@PostMapping("/doUpload")
	//public ResponseEntity<String>uploadProfile(@RequestBody UserProfile profile,@RequestParam(value="file") CommonsMultipartFile fileUpload,HttpSession session)
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadProfile(@RequestParam(value="file") CommonsMultipartFile fileUpload,HttpSession session)
	{
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		System.out.println(userDetail.getLoginName());
		System.out.println("File Byte :"+fileUpload.getBytes().length);
		
		if(userDetail==null)
		{
			return new ResponseEntity<String>("Unauthorised User",HttpStatus.NOT_FOUND);
		}
		else
		{
			UserProfile userProfile=new UserProfile();
			userProfile.setLoginName(userDetail.getLoginName());
			userProfile.setImage(fileUpload.getBytes());
			System.out.println("in doUpload()");
			userProfileDAO.save(userProfile);
			
			return new ResponseEntity<String>("Uploaded Picture..",HttpStatus.OK);
		}
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/getImage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getProfile(@PathVariable("username") String username,HttpSession session)
	{
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		
		if(userDetail==null)
		{
			return null;
		}
		else
		{
			//UserProfile userProfile=userProfileDAO.getProfilePicture(userDetail.getLoginName());
			System.out.println(" Name is "+username);
			UserProfile userProfile=userProfileDAO.getProfilePicture(username);
			if(userProfile !=null)
			{
				return userProfile.getImage();
			}
			else
			{
				return null;
			}
		}
	}
	
}
