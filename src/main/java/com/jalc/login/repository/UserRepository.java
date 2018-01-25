package com.jalc.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalc.login.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
