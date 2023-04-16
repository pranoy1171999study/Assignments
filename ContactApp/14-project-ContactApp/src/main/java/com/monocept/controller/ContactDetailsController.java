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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.ContactDetails;
import com.monocept.service.ContactDetailsService;

@RestController
@RequestMapping("/contactdetails")
@PreAuthorize("hasAuthority('ROLE_user')")
public class ContactDetailsController {

	@Autowired
	ContactDetailsService cdService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllContactDetailss() {
		List<ContactDetails> u=cdService.fildAll();
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@GetMapping("/contact/{id}")
	public ResponseEntity<?> getContactDetailsById(@PathVariable int id) {
		ContactDetails u=cdService.findContactDetailsbyId(id);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PostMapping("/save/{cid}/")
	public ResponseEntity<?> createContactDetails(@RequestParam int cid, @RequestBody ContactDetails contact) {
		ContactDetails u=cdService.createContactDetails(contact,cid);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@PutMapping("/edit")
	public ResponseEntity<?> editContactDetails(@RequestBody ContactDetails contact) {
		ContactDetails u=cdService.updateContactDetails(contact);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> deleteContactDetailsById(@PathVariable int id) {
		cdService.deleteContactDetailsbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}
