package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private  NewConstituencyService constituencyService;

	@Autowired
	private  NewCandidateService newCandidateService;

	@Autowired
	private UserService userServ;

	
	@RequestMapping("")
	public String dashboard(Model m,Principal p)
	
	{
		
		List<NewCandidate> allCandidates = newCandidateService.getAllCandidates();
    	m.addAttribute("allCandidates", allCandidates);
		
		String userName = p.getName(); // it will give the username(email) of person who is login		

		User user = userServ.getUserByEmail(userName);
		
        String constituencyName = user.getConstituency();
        Long constituencyId = constituencyService.getConstituencyIdByName(constituencyName);
        
        m.addAttribute("constituencyId", constituencyId);

        List<NewCandidate> candidatesByConstituency = newCandidateService.getCandidatesByConstituency(constituencyId);
        
        m.addAttribute("candidatesByConstituency", candidatesByConstituency);

		
		String status = "Not Voted";
		if (user.isHasVoted()== true) {
			
			status = "Voted";
		}
		
		m.addAttribute("status",status);
		
		m.addAttribute("user",user);
		
		
		m.addAttribute("title","Voter Home");
		
		
		
		
		return "user/dashboard";
	}
	
//=======================================================================================================================================
	
	@GetMapping("/register")
    public String addConstituency(Model model) {
    	
    	List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
    	model.addAttribute("allConstituencies", allConstituencies);
        //model.addAttribute("newConstituency", new NewConstituency());
        return "user/dashboard";
    }

    // Handler method to process the form submission and add the new constituency
    @PostMapping("/register")
    public String addConstituency(@ModelAttribute NewConstituency newConstituency) {
        constituencyService.addConstituency(newConstituency);
        return "user/dashboard"; // Redirect to the admin dashboard or another page
    }
    


}
