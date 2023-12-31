package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "new_voters")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private String email;
	//private int phone;
	private String constituency; 
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(
			name = "voters_roles",
			joinColumns = {@JoinColumn(name = "vid")},
			inverseJoinColumns = {@JoinColumn(name = "rid")}
			)
	List<Role> roles = new ArrayList<>();
	
	@Column(nullable = false)
    private boolean hasVoted = false;

	
	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public User()
	{
		
	}
	
public User(int id,String name, String password, String email, List<Role> roles, String constituency) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		//this.phone = phone;
		this.roles = roles;
		this.constituency=constituency;
	}

	public User(String name, String password, String email, List<Role> roles, String constituency) {
		
		this.name = name;
		this.password = password;
		this.email = email;
		//this.phone = phone;
		this.roles = roles;
		this.constituency=constituency;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public int getPhone() {
//		return phone;
//	}
//
//	public void setPhone(int phone) {
//		this.phone = phone;
//	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email 
				+ ", roles=" + roles + "]";
	}

	

	
	
	

	

}
