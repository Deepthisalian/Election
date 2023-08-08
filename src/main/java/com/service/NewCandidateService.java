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

		return newcandidateRepository.findAll();
	}
	
	
	public NewCandidate getCandidateByName(String candidateName) {
        return newcandidateRepository.findByCandidateName(candidateName);
    }

	public List<NewCandidate> getCandidatesByConstituency(Long constituencyId) {
		return newcandidateRepository.findByConstituencyId(constituencyId);
	}

    
}
