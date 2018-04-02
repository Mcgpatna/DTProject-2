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

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@RestController
public class BlogController 
{
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping("/value")
	public ResponseEntity<String>demo()
	{
		return new ResponseEntity<String>("Sucessfull",HttpStatus.OK);
		
	}
	

	@GetMapping("/showApprovedBlog")
	public ResponseEntity<List<Blog>> showApprovedBlog()
	{
		List<Blog> listBlogs=blogDAO.listApprovedBlogs("user1");
		
		if(listBlogs!=null)
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setLoginName("madhu");
		blog.setStatus("NA");
		
		System.out.println("Blog Name"+blog.getBlogName());
		System.out.println("Blog Contents"+blog.getBlogContent());
		
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Blog Addition Problem",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/approvedBlog/{blogId}")
	public ResponseEntity<String> approvedBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blog!=null)
		{
		String blgName=blog.getBlogName();
		if(blogDAO.approveBolg(blog))
		{
			return new ResponseEntity<String>(blgName+" Blog is Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Blog",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Blog",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blog !=null)
		{
			String blgName=blog.getBlogName();
		if(blogDAO.rejectBolg(blog))
		{
			return new ResponseEntity<String>(blgName+" Blog is Rejected",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blog!=null)
		{
		String blgName=blog.getBlogName();
		if(blogDAO.deleteBlog(blogId))
		{
			return new ResponseEntity<String>(blgName+" Blog is deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/increamentLike/{blogId}")
	public ResponseEntity<String> increamentLikeForBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blog!=null)
		{
		String blgName=blog.getBlogName();
		if(blogDAO.increaseLike(blog))
		{
			return new ResponseEntity<String>(" Likes gets increamented for "+blgName,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
		}
		}
		else
			return new ResponseEntity<String>("Error in getting Blog details",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("getABlog/{blogId}")
	public ResponseEntity<Blog>getABlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blog!=null)
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
		}
	}
	
}
