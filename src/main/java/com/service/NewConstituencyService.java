package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Candidate;
import com.model.NewConstituency;
import com.repository.NewConstituencyRepo;

@Service
public class NewConstituencyService {
    private  NewConstituencyRepo constituencyRepository;

    @Autowired
    public NewConstituencyService(NewConstituencyRepo constituencyRepository) {
        this.constituencyRepository = constituencyRepository;
    }

    public void addConstituency(NewConstituency constituency) {
        constituencyRepository.save(constituency);
    }
    
    public List<NewConstituency> getAllConstituencies() {
        return constituencyRepository.findAll();
    }
    
    public void addCandidateToConstituency(Candidate candidate, Integer constituencyId) {
        NewConstituency constituency = constituencyRepository.findById(constituencyId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Constituency ID"));

        candidate.setConstituency(constituency);
        constituency.getCandidates().add(candidate);

        constituencyRepository.save(constituency);
    }

    // Add other methods as needed for constituency management
}


