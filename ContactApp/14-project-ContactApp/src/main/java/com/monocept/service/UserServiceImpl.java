package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.User;
import com.monocept.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		return userRepo.save(user);	
	}

	@Override
	public User findUserbyId(int id) {
		Optional<User> ouser=userRepo.findById(id);
		if(!ouser.isPresent()) {
			return null;
		}
		return ouser.get();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUserbyId(int id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public List<User> fildAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
