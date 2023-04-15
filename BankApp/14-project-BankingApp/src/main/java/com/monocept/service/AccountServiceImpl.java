package com.monocept.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Accounts;
import com.monocept.entity.Bank;
import com.monocept.entity.Customer;
import com.monocept.entity.Tranjuctions;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.BankRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.repository.TranjuctionRepository;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountRepository accRepo;
	@Autowired
	BankRepository bankRepo;
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	TranjuctionRepository trRepo;

	@Override
	public Accounts save(Accounts acc) {
		return accRepo.save(acc);
	}

	@Override
	public void deleteById(int id) {
		accRepo.deleteById(id);
	}

	@Override
	public Optional<Accounts> getById(int id) {
		// TODO Auto-generated method stub
		return accRepo.findById(id);
	}

	

	@Override
	public List<Accounts> findAllByBankId(int bank_id) {
		// TODO Auto-generated method stub
		return accRepo.findAllByBank(bank_id);
	}

	
	@Override
	public Accounts update(int acc, int bankId,int cid) {
		try {
		Optional<Customer> customer=cRepo.findById(cid);
		Optional<Bank> bank= bankRepo.findById(bankId);
		Optional< Accounts> account=accRepo.findById(acc);
		if(!customer.isPresent()||!bank.isPresent()||!account.isPresent()) {
			return null;
		}
		if(account.get().getC_id()!=null) {
			return null;
		}
		account.get().setBank(bank.get());
		account.get().setC_id(customer.get());
		return accRepo.save(account.get());
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Accounts> findAll() {
		return accRepo.findAll();
	}
	@Override
	public List<Accounts> getCustomerWithAccounts(int cid) {
		Optional<Customer> cs=cRepo.findById(cid);
		if(!cs.isPresent()) {
			return null;
		}
		Customer customer=cs.get();
		List<Accounts> accounts=accRepo.findAllByCid(customer);
		
		return accounts;
	}

	@Override
	public List<Accounts> find10AccountsBySearchTerm(int term) {
		return accRepo.find10AccountsBySearchTerm(term);
	}

	
}
