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

import com.monocept.entity.Contact;
import com.monocept.service.ContactService;

@RestController 
@RequestMapping("/contact")
@PreAuthorize("hasAuthority('ROLE_user')")
public class ContactController {

	@Autowired
	ContactService cService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllContacts() {
		List<Contact> u=cService.fildAll();
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@GetMapping("/contact/{id}")
	public ResponseEntity<?> getContactById(@PathVariable int id) {
		Contact u=cService.findContactbyId(id);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PostMapping("/save/{uid}/")
	public ResponseEntity<?> createContact(@RequestParam int uid, @RequestBody Contact contact) {
		Contact u=cService.createContact(contact,uid);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@PutMapping("/edit")
	public ResponseEntity<?> editContact(@RequestBody Contact contact) {
		Contact u=cService.updateContact(contact);
		System.out.println(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> deleteContactById(@PathVariable int id) {
		cService.deleteContactbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
}
