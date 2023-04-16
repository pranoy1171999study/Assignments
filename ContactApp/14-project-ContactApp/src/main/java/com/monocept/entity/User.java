package com.monocept.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "port_user", sequenceName = "port_user",  initialValue = 10000001)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "port_user")
	int userId;
	String fName;
	String lName;
	String password;
	boolean isAdmin;
	boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user") 
	@JsonIgnore
	List<Contact> contacts=new ArrayList<Contact>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String fName, String lName ,String password, boolean isAdmin, boolean isActive) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.password=password;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
