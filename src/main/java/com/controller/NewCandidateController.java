package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.NewCandidate;
import com.service.NewCandidateService;

@Controller

public class NewCandidateController {

    private NewCandidateService newCandidateService;

    @Autowired
    public NewCandidateController(NewCandidateService newCandidateService) {
        this.newCandidateService = newCandidateService;
    }

    // Handler method to display all candidates on the user dashboard
//    @GetMapping("/user")
//    public String showAllCandidates(Model model) {
//        List<NewCandidate> allCandidates = newCandidateService.getAllCandidates();
//        model.addAttribute("allcandidates", allCandidates);
//        return "/user"; // Assuming you have a Thymeleaf template named "dashboard.html" in the "user" folder
//    }
    
    

    // Add other handler methods for candidate management if needed
}
