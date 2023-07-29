package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Candidate;
import com.model.NewConstituency;
import com.service.NewConstituencyService;

@Controller
@RequestMapping("/admin")
public class NewConstituencyController {

    private final NewConstituencyService constituencyService;

    @Autowired
    public NewConstituencyController(NewConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }


    // Handler method to show the form for adding a new constituency
    @GetMapping("/addnewconstituency")
    public String addConstituency(Model model) {
    	
    	List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
    	model.addAttribute("allConstituencies", allConstituencies);
        model.addAttribute("newConstituency", new NewConstituency());
        return "admin/addnewconstituency";
    }

    // Handler method to process the form submission and add the new constituency
    @PostMapping("/addnewconstituency")
    public String addConstituency(@ModelAttribute NewConstituency newConstituency) {
        constituencyService.addConstituency(newConstituency);
        return "redirect:/admin/"; // Redirect to the admin dashboard or another page
    }
    
   
    
    @GetMapping("/addnewcandidate")
    public String showAddCandidateForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("constituencies", constituencyService.getAllConstituencies());
        return "admin/addnewcandidate";
    }

    // Handler method to process the form submission and add the new candidate to a constituency
    @PostMapping("/addnewcandidate")
    public String addCandidate(@ModelAttribute Candidate candidate, @RequestParam Integer constituencyId) {
    	if (constituencyId != null) {
            constituencyService.addCandidateToConstituency(candidate, constituencyId);
        }
    	
        return "redirect:/admin/" + constituencyId;
    }

    // Handler method to view all constituencies (optional)


    // Add other handler methods for constituency management if needed
}
