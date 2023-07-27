package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.NewConstituency;

@Repository
public interface NewConstituencyRepo extends JpaRepository<NewConstituency, Integer> {
    // You can add custom query methods here if needed
}
