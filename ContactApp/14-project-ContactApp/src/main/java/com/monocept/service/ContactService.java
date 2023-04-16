package com.monocept.service;

import java.util.List;

import com.monocept.entity.Contact;
import com.monocept.entity.User;


public interface ContactService {
	public Contact createContact(Contact contact,int uid);
	public Contact findContactbyId(int id);
	public List<Contact> fildAll();
	public Contact updateContact(Contact contact);
	public void deleteContactbyId(int id);
}
