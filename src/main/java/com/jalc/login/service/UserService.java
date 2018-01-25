package com.jalc.login.service;

import com.jalc.login.model.User;

public interface UserService {
	void save(User user);
	
	User findByUsername(String username);
}
