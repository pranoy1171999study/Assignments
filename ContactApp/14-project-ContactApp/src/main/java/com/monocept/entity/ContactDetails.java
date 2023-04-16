package com.monocept.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ContactDetailsId;
	ContactType contactType;
	String value;
	
	@ManyToOne
	Contact contact;
	
	public ContactDetails() {
		// TODO Auto-generated constructor stub
	}


	public ContactDetails(ContactType contactType,String value) {
		super();
		this.contactType = contactType;
		this.value=value;
	}
	


	public int getContactDetailsId() {
		return ContactDetailsId;
	}


	public void setContactDetailsId(int contactDetailsId) {
		ContactDetailsId = contactDetailsId;
	}


	public ContactType getContactType() {
		return contactType;
	}


	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
