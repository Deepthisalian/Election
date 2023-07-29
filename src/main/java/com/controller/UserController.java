package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.NewConstituency;
import com.model.User;
import com.service.CandidateService;
import com.service.NewConstituencyService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	private  NewConstituencyService constituencyService;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private CandidateService cndServ;
	
	@RequestMapping("")
	public String dashboard(Model m,Principal p)
	{
		String userName = p.getName(); // it will give the username(email) of person who is login		

		User user = userServ.getUserByEmail(userName);
		
		
		String status = "Not Voted";
		if (cndServ.getCandByUser(userName) != null) {
			
			status = "Voted";
		}
		
		m.addAttribute("status",status);
		
		m.addAttribute("user",user);
		
		
		m.addAttribute("title","Voter Home");
		
		
		return "user/dashboard";
	}
	
	@GetMapping("/register")
    public String addConstituency(Model model) {
    	
    	List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
    	model.addAttribute("allConstituencies", allConstituencies);
        model.addAttribute("newConstituency", new NewConstituency());
        return "user/dashboard";
    }

    // Handler method to process the form submission and add the new constituency
    @PostMapping("/register")
    public String addConstituency(@ModelAttribute NewConstituency newConstituency) {
        constituencyService.addConstituency(newConstituency);
        return "user/dashboard"; // Redirect to the admin dashboard or another page
    }

}
