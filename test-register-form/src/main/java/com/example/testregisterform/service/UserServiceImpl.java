package com.example.testregisterform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.testregisterform.dao.UserRepository;
import com.example.testregisterform.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository theRepo) {
		this.userRepository = theRepo;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		
		Optional<User> res = userRepository.findById(theId);
		
		User tempUser = null;
		if (res.isPresent()) {
			tempUser = res.get();
		}
		else {
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return tempUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}
	
	public User findByName(String name) {
		
		return null;
	}

}
