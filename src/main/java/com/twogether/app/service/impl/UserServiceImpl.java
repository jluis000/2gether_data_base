package com.twogether.app.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.twogether.app.model.User;
import com.twogether.app.repository.UserRepository;
import com.twogether.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(Long id, User user) {
		User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setCountry(user.getCountry());
        existingUser.setPhotoUrl(user.getPhotoUrl());
        existingUser.setAboutMe(user.getAboutMe());
        existingUser.setRating(user.getRating());
        existingUser.setNumReviewers(user.getNumReviewers());

        return userRepository.save(existingUser);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
