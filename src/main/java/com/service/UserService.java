package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.NewCandidate;
import com.model.NewConstituency;
import com.model.User;
import com.repository.NewCandidateRepo;
import com.repository.NewConstituencyRepo;
import com.repository.UserRepository;

@Service
public class UserService {
	
	 private  NewConstituencyRepo constituencyRepository;
	 
	 private  NewCandidateRepo newCandidateRepository;
	 
	
	@Autowired
	private UserRepository userrepo;
	
	
	public void addUser(User user)
	{
		userrepo.save(user);
	}
	
	public List<User> getAllUsers()
	{
		return userrepo.findAll();
	}
	
	public User getUserById(int id)
	{
		Optional<User> user = userrepo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}

	public void deleteUser(int id)
	{
		userrepo.deleteById(id);
	}
	
	public User getUserByEmail(String email)
	{
		return userrepo.getUserByEmail(email);
	}
	
	public User getUserByPassword(String voterID)
	{
		return userrepo.getUserByPassword(voterID);
	}
	
	public List<NewConstituency> getAllConstituencies() {
        return constituencyRepository.findAll();
    }
	
	public List<NewCandidate> getAllCandidates() {
        return newCandidateRepository.findAll();
    }

	
	
	
}
