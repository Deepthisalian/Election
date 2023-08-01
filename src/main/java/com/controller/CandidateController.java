package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Candidate;
import com.model.NewCandidate;
import com.model.NewConstituency;
import com.model.User;
import com.service.CandidateService;
import com.service.NewCandidateService;
import com.service.UserService;



@Controller
public class CandidateController {
	
	@Autowired
	private CandidateService cndServ;
	
	@Autowired
	private NewCandidateService newCandidateService;
	
	@Autowired
	private UserService userService;
	

	
	@PostMapping("/addcandidate")
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
		        //userService.saveUser(user);
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
