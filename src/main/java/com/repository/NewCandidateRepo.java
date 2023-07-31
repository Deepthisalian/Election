package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.NewCandidate;
import com.model.NewConstituency;

@Repository
public interface NewCandidateRepo extends JpaRepository<NewCandidate, Integer> {
	
	List<NewCandidate> findAll();

	NewCandidate findByCandidateName(String candidateName);

	List<NewCandidate> findByConstituencyId(Long constituencyId);
	
	
}


