package com.monocept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Accounts;
import com.monocept.entity.Customer;
import com.monocept.entity.Tranjuctions;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.repository.TranjuctionRepository;

@Service
public class TranjuctionServiceImpl implements TranjuctionService{
	@Autowired
	TranjuctionRepository trRepo;
	@Autowired
	AccountRepository accRepo;
	@Autowired
	CustomerRepository cRepo;

	@Override
	public Tranjuctions save(Tranjuctions tranjuction) {
		// TODO Auto-generated method stub
		return trRepo.save(tranjuction);
	}

	@Override
	public void deleteById(int id) {
		trRepo.deleteById(id);
		
	}

	@Override
	public Optional<Tranjuctions> getById(int id) {
		// TODO Auto-generated method stub
		return trRepo.findById(id);
	}

	@Override
	public List<Tranjuctions> findAllByCid(int cid) {
		Customer costomer=cRepo.findById(cid).get();
		List<Accounts> accounts=accRepo.findAllByCid(costomer);
		List<Integer> accNos=new ArrayList<Integer>();
		for(Accounts acc:accounts) {
			accNos.add(acc.getAccNo());
		}
		return trRepo.findAllTranjuctionsByAccounts(accNos);
	}

	@Override
	public List<Tranjuctions> findAll() {
		// TODO Auto-generated method stub
		return trRepo.findAll();
	}
	@Override
	public String transferMoney(int sender, int reciever, int amount) {
		Optional<Accounts> senderO=accRepo.findById(sender);
		Optional<Accounts> recieverO=accRepo.findById(reciever);
		if(!senderO.isPresent()) {
			return "invalid Sender + "+sender;
		}
		if(!recieverO.isPresent()) {
			return "invalid Reciever "+reciever;
		}
		Accounts senderAccount=senderO.get();
		Accounts recieverAccount=recieverO.get();
		if(amount<0) {
			return "invalid Amount";
		}
		
		if(senderAccount.getBalance()<amount) {
			return "Insufficeien Balance";
		}
		if(!senderAccount.setBalance((int)senderAccount.getBalance()-amount)){
			return "Insufficeien Balance";
			
		}
		recieverAccount.setBalance((int)recieverAccount.getBalance()+amount);
		accRepo.save(senderAccount);
		accRepo.save(recieverAccount);
		Tranjuctions tr=new Tranjuctions();
		tr.setSender(sender);
		tr.setReciever(reciever);
		tr.setAmount(amount);
		trRepo.save(tr);
		return "successful";
	}
}
