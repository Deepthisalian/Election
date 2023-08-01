package com.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.NewConstituency;
import com.model.Role;
import com.model.User;
import com.service.NewConstituencyService;
import com.service.RoleService;
import com.service.UserService;



@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userserv;
	
	@Autowired
	private RoleService roleserv;
	
	@Autowired
	private  NewConstituencyService constituencyService;

	@GetMapping("/")
	public String index(Model m)
	{
		
		m.addAttribute("title","Home");
		return "home";
	}
	
	
	
	@GetMapping("/signin")
	public String signin(Model m)
	{
		m.addAttribute("title","Signin");
		return "signin";
	}
	
	
	
	@GetMapping("/register")
	public String register(Model m)
	{
		
		
		m.addAttribute("title","Registration");
		List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
    	m.addAttribute("allConstituencies", allConstituencies);
        m.addAttribute("newConstituency", new NewConstituency());
		return "register";
	}

	@PostMapping("/createuser")
	public String createuser(@ModelAttribute User user,HttpSession session)
	{		
		int i= 0;
		int vid = 0;
		
		try
		{
		String email = user.getEmail();
		
			if(userserv.getUserByEmail(email) != null)
			{
				i++;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if(i >= 1)
		{
			session.setAttribute("msg","Registration Failed,Please try different email id");
			return "redirect:/register";
		}
		
		try
		{
		String voterID = user.getPassword();
		
			if(userserv.getUserByPassword(voterID) != null)
			{
				vid++;
				System.out.println(vid+"vid----------");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if(vid >= 1)
		{
			session.setAttribute("msg","Registration Failed,Please try different voter id");
			return "redirect:/register";
		}
		
		
			List<Role> r = new ArrayList<>();
			r.add(roleserv.getRoleByName("ROLE_USER"));
		
			 user.setRoles(r);
			 userserv.addUser(user);
			
			session.setAttribute("msg","Registration Successful...");
			
			return "redirect:/register";
		
		
	}
	
	
	
}

