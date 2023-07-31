package com.model;

import javax.persistence.*;

import com.repository.NewCandidateRepo;

@Entity
@Table(name = "new_candidate")
public class NewCandidate {

    
	public NewCandidate(String candidateName, NewConstituency constituency, int voteCount, Long id) {
		super();
		this.candidateName = candidateName;
		this.constituency = constituency;
		this.voteCount = voteCount;
		this.id = id;
	}


	@Id
    private String candidateName;

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
    	this.candidateName = candidateName;
	}
    
    

	public Long getId() {
		return id;
	}

	public String getCandidateName() {
		return candidateName;
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

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public void setConstituency(NewConstituency constituency) {
		this.constituency = constituency;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}


	@Override
	public String toString() {
		return "NewCandidate [id=" + id + ", name=" + candidateName + ", constituency=" + constituency + ", voteCount="
				+ voteCount + "]";
	}



    // Constructors, Getters, and Setters (Omitted for brevity)
}
