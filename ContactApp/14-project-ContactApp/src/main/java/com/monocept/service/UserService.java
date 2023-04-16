package com.monocept.service;

import java.util.List;

import com.monocept.entity.User;

public interface UserService {
	public User createUser(User user);
	public User findUserbyId(int id);
	public List<User> fildAll();
	public User updateUser(User user);
	public void deleteUserbyId(int id);
	
}
