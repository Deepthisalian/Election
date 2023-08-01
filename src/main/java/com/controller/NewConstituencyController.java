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


import com.model.NewCandidate;
import com.model.NewConstituency;
import com.service.NewCandidateService;
import com.service.NewConstituencyService;

@Controller
@RequestMapping("/admin")
public class NewConstituencyController {

    private NewConstituencyService constituencyService;
    
    private NewCandidateService newcandidateService;

    @Autowired
    public NewConstituencyController(NewConstituencyService constituencyService, NewCandidateService newcandidateService) {
        this.constituencyService = constituencyService;
        this.newcandidateService = newcandidateService; // Initialize the newcandidateService
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
    public String addnewConstituency(Model model) {
    	
    	List<NewConstituency> allConstituencies = constituencyService.getAllConstituencies();
    	model.addAttribute("allConstituencies", allConstituencies);
        model.addAttribute("newConstituency", new NewConstituency());
        return "admin/addnewcandidate";
    }

    
    
    @PostMapping("/addnewcandidate")
    public String addCandidateToConstituency(@RequestParam String newConstituency,
                                             @RequestParam String candidateName) {

        // Find the existing constituency by its ID
        NewConstituency constituency = constituencyService.getConstituencyByName(newConstituency);

        if (constituency != null) {
            // Create a new candidate object and set its name
            NewCandidate newCandidate = new NewCandidate(candidateName);
            
            
            newCandidate.setCandidateName(candidateName);
            // Set the constituency for the candidate
            newCandidate.setConstituency(constituency);

            // Save the candidate to the database
            newcandidateService.saveCandidate(newCandidate);

         
            return "redirect:/admin/";
        } else {
          
            return "redirect:/admin/addnewconstituency";} // Redirect back to the form page
        }
    
    
        public String addnewConstituency(@ModelAttribute NewConstituency newConstituency) {
            constituencyService.addConstituency(newConstituency);
            return "user/dashboard"; // Redirect to the admin dashboard or another page
        
    }
	

}
