package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Candidate;
import com.model.NewConstituency;

@Repository
public interface NewConstituencyRepo extends JpaRepository<NewConstituency, Integer> {

	
	NewConstituency findByName(String constituency);

	//NewConstituency findByConstituencyName(String constituencyName);

	 

	
    
}
