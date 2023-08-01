package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.model.NewCandidate;
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
    
    public void addCandidateToConstituency(NewCandidate newcandidate, String constituency) {
        NewConstituency constituency1 = constituencyRepository.findByName(constituency);
                

        newcandidate.setConstituency(constituency1);
        constituency1.getCandidates().add(newcandidate);

        constituencyRepository.save(constituency1);
    }

	public NewConstituency getConstituencyByName(String newConstituency) {
	
		return constituencyRepository.findByName(newConstituency);
	}
    
	
	//imp
	public Long getConstituencyIdByName(String constituencyName) {
        NewConstituency constituency = constituencyRepository.findByName(constituencyName);
        System.out.println("hello----------------"+constituency.getId());
        return constituency != null ? constituency.getId() : null;
    }
//    public NewConstituency getConstituencyByName(String constituencyName) {
//        return constituencyRepository.findByName(constituencyName);
//    }


	

	

    // Add other methods as needed for constituency management
}


