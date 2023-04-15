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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Accounts;
import com.monocept.entity.Customer;
import com.monocept.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveAccount(@RequestBody Accounts acc) {
		 accService.save(acc);
		 return ResponseEntity.status(HttpStatus.OK).body(acc);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable int id) {
		 accService.deleteById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccount(@PathVariable int id) {
		Optional<Accounts> e=accService.getById(id);
		 return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@GetMapping("")
	public ResponseEntity<?> getAccounts() {
		List<Accounts> accounts=accService.findAll();
		 return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerWithAccounts(@PathVariable int id) {
		List<Accounts> e=accService.getCustomerWithAccounts(id);
		 return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@GetMapping("/search/{term}")
	public ResponseEntity<?> getCustomerBySearchTerm(@PathVariable int term) {
		List<Accounts> e=accService.find10AccountsBySearchTerm(term);
		 return ResponseEntity.status(HttpStatus.OK).body(e);
	}
	@PutMapping("/set/{accId}/bank/{bankId}/cid/{cId}")
	public Accounts setAccount(@PathVariable int accId,
								  @PathVariable int bankId,@PathVariable int cId) {
		Accounts account=accService.update(accId,bankId,cId);
		return account;
	}
	
}
