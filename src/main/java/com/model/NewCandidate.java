package com.model;

import javax.persistence.*;

@Entity
public class NewCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

	private String name;

    @ManyToOne
    @JoinColumn(name = "constituency_id")
    private NewConstituency constituency;

    private int voteCount;
    private Long id;

    public NewCandidate(String candidateName) {
    	this.name = candidateName;
	}
    
    

	public Long getId() {
		return id;
	}

	public String getName() {
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

	public void setName(String name) {
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
