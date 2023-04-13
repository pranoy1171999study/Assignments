package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;

import com.monocept.entity.Accounts;
import com.monocept.entity.Bank;

public interface BankService {
	public Bank save(Bank bank);
	public void deleteById(int id);
	public Optional<Bank> getById(int id);
	public List<Bank> findAll();
	public List<Accounts> findAllAccounts(int bank_id);
}
