package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.User;
import com.monocept.service.UserService;

@RestController
@RequestMapping("/userapp")
//@PreAuthorize("hasAuthority('ROLE_admin')")
public class UserController {
	@Autowired
	UserService uService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUsers() {
		List<User> u=uService.fildAll();
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		User u=uService.findUserbyId(id);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User u=uService.createUser(user);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@PutMapping("/edit")
	public ResponseEntity<?> editUser(@RequestBody User user) {
		User u=uService.updateUser(user);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id) {
		uService.deleteUserbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
}
