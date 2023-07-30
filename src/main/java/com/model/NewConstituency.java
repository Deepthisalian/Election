package com.model;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class NewConstituency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    
    @OneToMany(mappedBy = "constituency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewCandidate> newcandidates = new ArrayList<>();
  

	public List<NewCandidate> getCandidates() {
		return newcandidates;
	}
	public void setCandidates(List<NewCandidate> newcandidates) {
		this.newcandidates = newcandidates;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "NewConstituency [id=" + id + ", name=" + name + "]";
	}
}