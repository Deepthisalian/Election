package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.NewCandidate;
import com.repository.NewCandidateRepo;

import java.util.List;
import java.util.ArrayList;

@Service
public class NewCandidateService {

    private NewCandidateRepo newcandidateRepository;

    @Autowired
    public NewCandidateService(NewCandidateRepo newcandidateRepository) {
        this.newcandidateRepository = newcandidateRepository;
    }

    @Transactional
	public void saveCandidate(NewCandidate newCandidate) {
		 newcandidateRepository.save(newCandidate);
		
	}

	public List<NewCandidate> getAllCandidates() {
//		List<NewCandidate> candidates = new ArrayList<>();
//
//        // Create some sample NewCandidate objects and add them to the list
//        NewCandidate candidate1 = new NewCandidate("C1");
//        NewCandidate candidate2 = new NewCandidate("C2");
//        NewCandidate candidate3 = new NewCandidate("C3");
//        NewCandidate candidate4 = new NewCandidate("C4");
//
//        candidates.add(candidate1);
//        candidates.add(candidate2);
//        candidates.add(candidate3);
//        candidates.add(candidate4);
//        
//        System.out.println("Candidate//////////"+candidates);
//
//        return candidates;
		return newcandidateRepository.findAll();
	}
	
	
	
	public NewCandidate getCandidateByName(String candidateName) {
        return newcandidateRepository.findByCandidateName(candidateName);
    }

	public List<NewCandidate> getCandidatesByConstituency(Long constituencyId) {
		return newcandidateRepository.findByConstituencyId(constituencyId);
	}
	
	

	

//    public List<NewCandidate> getAllCandidates() {
//        return newcandidateRepository.findAll();
//    }
    
}
