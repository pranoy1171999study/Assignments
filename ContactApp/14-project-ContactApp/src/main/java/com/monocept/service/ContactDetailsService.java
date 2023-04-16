package com.monocept.service;

import java.util.List;

import com.monocept.entity.ContactDetails;
import com.monocept.entity.User;

public interface ContactDetailsService {
	public ContactDetails createContactDetails(ContactDetails cdetails,int contactId);
	public ContactDetails findContactDetailsbyId(int id);
	public List<ContactDetails> fildAll();
	public ContactDetails updateContactDetails(ContactDetails cdetails);
	public void deleteContactDetailsbyId(int id);
}
