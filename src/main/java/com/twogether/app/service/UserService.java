package com.twogether.app.service;

import com.twogether.app.model.User;

public interface UserService {
	
	User save(User user);
	
	User findById(Long id);
	
	Iterable<User> findAll();
	
	User update(Long id, User user);
	
	void deleteById(Long id);
	
}
