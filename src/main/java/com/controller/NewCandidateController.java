package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.NewCandidate;
import com.model.NewConstituency;
import com.model.User;

import com.service.NewCandidateService;
import com.service.NewConstituencyService;
import com.service.UserService;

@Controller

public class NewCandidateController {

	
	@Autowired
	private NewCandidateService newCandidateService;
	
	@Autowired
	private NewConstituencyService newConstituencyService;
	
	@Autowired
	private UserService userService;

    @Autowired
    public NewCandidateController(NewCandidateService newCandidateService) {
        this.newCandidateService = newCandidateService;
    }
    
    @PostMapping("/checkstatus")
	public String addCandidate(@RequestParam("candidate") String candidate, 
			Principal p,Model model, HttpSession session)
	{
		String email = p.getName();
		
		
	    User user = userService.getUserByEmail(email);
		
	    if (user.isHasVoted()) {
	        session.setAttribute("msg", "You have already voted.");
	    }
			
			else {
				
				user.setHasVoted(true);
	            NewCandidate selectedCandidate = newCandidateService.getCandidateByName(candidate);

	            if (selectedCandidate != null) {
	                selectedCandidate.setVoteCount(selectedCandidate.getVoteCount() + 1);
	                newCandidateService.saveCandidate(selectedCandidate);
	                
	               
	                session.setAttribute("msg", "Successfully Voted...");
	            } else {
	                session.setAttribute("msg", "Candidate not found.");
	            }            	
			
		}
		
		
		
		return "redirect:user/";
	}

}

