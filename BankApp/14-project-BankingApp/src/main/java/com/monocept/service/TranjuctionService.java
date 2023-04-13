package com.monocept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.monocept.entity.Accounts;
import com.monocept.entity.Tranjuctions;

public interface TranjuctionService {
	public Tranjuctions save(Tranjuctions tranjuctions);
	public void deleteById(int id);
	public Optional<Tranjuctions> getById(int id);
	public List<Tranjuctions> findAllByCid(int cid  );
	public List<Tranjuctions> findAll();
	public String transferMoney(int sender,int reciever,int amount);
}
