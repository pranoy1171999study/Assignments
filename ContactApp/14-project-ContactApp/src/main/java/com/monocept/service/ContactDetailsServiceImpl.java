package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.entity.ContactDetails;
import com.monocept.repository.ContactDetailsRepository;
import com.monocept.repository.ContactRepository;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService{

	@Autowired
	ContactDetailsRepository cdetailsRepo;
	@Autowired
	ContactRepository cRepo;

	@Override
	public ContactDetails createContactDetails(ContactDetails cdetails,int contactId) {
		// TODO Auto-generated method stub
		Optional<Contact> contact=cRepo.findById(contactId);
		if(!contact.isPresent()) {
			return null;
		}
		cdetails.setContact(contact.get());
		ContactDetails cd=cdetailsRepo.save(cdetails);
		return cd;
	}

	@Override
	public ContactDetails findContactDetailsbyId(int id) {
		// TODO Auto-generated method stub
		Optional<ContactDetails> cdet=cdetailsRepo.findById(id);
		if(!cdet.isPresent()) {
			return null;
		}
		return cdet.get();
	}

	@Override
	public ContactDetails updateContactDetails(ContactDetails cdetails) {
		// TODO Auto-generated method stub
		return cdetailsRepo.save(cdetails);
	}

	@Override
	public void deleteContactDetailsbyId(int id) {
		cdetailsRepo.deleteById(id);
		
	}

	@Override
	public List<ContactDetails> fildAll() {
		// TODO Auto-generated method stub
		return cdetailsRepo.findAll();
	}
	

}
