package com.controller;

import java.security.Principal;
import java.util.*;
import com.google.gson.Gson;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Admin;

import com.model.NewCandidate;
import com.model.NewConstituency;
import com.model.User;
import com.service.AdminService;

import com.service.NewCandidateService;
import com.service.NewConstituencyService;
import com.service.RoleService;
import com.service.UserService;
import java.util.ArrayList;


@Controller
@RequestMapping("/admin")
public class AdminController {


	
	@Autowired
	private AdminService admServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private RoleService roleServ;
	
	@Autowired
	private NewConstituencyService constituencyService;
	
	@Autowired
	private NewCandidateService newcandidateService;
	

	    @Autowired
	    public AdminController(NewCandidateService newcandidateService, NewConstituencyService constituencyService) {
	        this.newcandidateService = newcandidateService;
	        this.constituencyService = constituencyService;
	    }


		
		
//=======================================================================================================================================	
	    
	@RequestMapping("")
	public String dashboard(Model m,Principal p)
	{
		

		List<NewCandidate> allCandidates = newcandidateService.getAllCandidates();
		m.addAttribute("allCandidates", allCandidates);
		m.addAttribute("title","Admin Home");
		
		return "admin/dashboard";
	}
	
//=======================================================================================================================================	

			
			@GetMapping("/displayresults")
			public String displayResults(Model m) {
				
				
			    List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
			    
			    m.addAttribute("allConstituencies", allConstituencies);
			    
			    List<NewCandidate> allCandidates = newcandidateService.getAllCandidates();
				m.addAttribute("allCandidates", allCandidates);
				
				//List<NewConstituency> allConstituencies = newConstituencyService.getAllConstituencies();
			    Map<Long, List<NewCandidate>> candidatesByConstituencies = new HashMap<>();

			    for (NewConstituency constituency : allConstituencies) {
			        List<NewCandidate> candidates = newcandidateService.getCandidatesByConstituency(constituency.getId());
			        candidatesByConstituencies.put(constituency.getId(), candidates);
			    }

			    m.addAttribute("allConstituencies", allConstituencies);
			    m.addAttribute("candidatesByConstituencies", candidatesByConstituencies);
		        
		        System.out.println("candidatesByConstituencies---------"+ candidatesByConstituencies);
				
				
			    return "admin/displayresults";
			}}


//=======================================================================================================================================	


