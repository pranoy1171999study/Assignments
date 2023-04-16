package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
