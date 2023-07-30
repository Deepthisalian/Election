package com.model;

import javax.persistence.*;

import com.repository.NewCandidateRepo;

@Entity
public class NewCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

	private String name;

    @ManyToOne
    @JoinColumn(name = "constituency_id")
    private NewConstituency constituency;
    
    //NewCandidateRepo newCandidateRepository;

    private int voteCount;
    private Long id;
    
    public NewCandidate() {
        // Default constructor with no arguments
    }
    
    public NewCandidate(String candidateName) {
    	this.name = candidateName;
	}
    
    

	public Long getId() {
		return id;
	}

	public String getCandidateName() {
		return name;
	}

	public NewConstituency getConstituency() {
		return constituency;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCandidateName(String name) {
		this.name = name;
	}

	public void setConstituency(NewConstituency constituency) {
		this.constituency = constituency;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}


	@Override
	public String toString() {
		return "NewCandidate [id=" + id + ", name=" + name + ", constituency=" + constituency + ", voteCount="
				+ voteCount + "]";
	}



    // Constructors, Getters, and Setters (Omitted for brevity)
}
