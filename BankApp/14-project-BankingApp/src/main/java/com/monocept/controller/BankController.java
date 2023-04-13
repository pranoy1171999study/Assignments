package com.monocept.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Bank;
import com.monocept.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankService bankService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBank(@RequestBody Bank acc) {
		bankService.save(acc);
		 return ResponseEntity.status(HttpStatus.OK).body(acc);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBank(@PathVariable int id) {
		bankService.deleteById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBank(@PathVariable int id) {
		Optional<Bank> e=bankService.getById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@GetMapping("")
	public ResponseEntity<?> getBanks() {
		List<Bank> accounts=bankService.findAll();
		 return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
	
}
