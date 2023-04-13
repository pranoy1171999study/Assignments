package com.monocept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monocept.entity.Tranjuctions;

@Repository
public interface TranjuctionRepository extends JpaRepository<Tranjuctions, Integer>{
	@Query(value="SELECT  * FROM Tranjuctions t WHERE t.reciever IN (:accounts) or Sender IN (:accounts)", 
		     nativeQuery = true)
	public List<Tranjuctions> findAllTranjuctionsByAccounts( @Param("accounts") List<Integer> accounts);
}
