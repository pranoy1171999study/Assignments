package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;

import com.monocept.entity.Accounts;
import com.monocept.entity.Customer;

public interface AccountService {
	public Accounts save(Accounts acc);
	public void deleteById(int id);
	public Optional<Accounts> getById(int id);
	public List<Accounts> findAll();
	public List<Accounts> findAllByBankId(int bank_id);
	public Accounts update(int acc_id,int cid, int bankId);
	public List<Accounts> getCustomerWithAccounts(int cid);
	public List<Accounts> find10AccountsBySearchTerm(int term);
	
}
