package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.repository.ContactRepository;
import com.monocept.repository.UserRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepository crepo;
	@Autowired
	UserRepository uRepo;
	
	@Override
	public Contact createContact(Contact contact,int uid) {
		// TODO Auto-generated method stub
		Optional<com.monocept.entity.User> user=uRepo.findById(uid);
		if(!user.isPresent()) {
			return null;
		}
		contact.setUser(user.get());
		return crepo.save(contact);
	}

	@Override
	public Contact findContactbyId(int id) {
		// TODO Auto-generated method stub
		Optional<Contact> contact=crepo.findById(id);
		if(!contact.isPresent()) {
			return null;
		}
		return contact.get();
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return crepo.save(contact);
	}

	@Override
	public void deleteContactbyId(int id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);
		
	}

	@Override
	public List<Contact> fildAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

}
