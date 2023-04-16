package com.monocept.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name = "port_contact", sequenceName = "port_contact",  initialValue = 10000001)
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "port_contact")
	int contactId;
	String fName;
	String lName;
	boolean isActive;
	
	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "contact") 
	@JsonIgnore
	List<ContactDetails> contactDetails=new ArrayList<ContactDetails>();
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String fName, String lName, boolean isActive) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.isActive = isActive;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
