package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.NewCandidate;
import com.repository.NewCandidateRepo;

import java.util.List;

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

    
}
