package com.twogether.app.service.impl;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twogether.app.model.User;
import com.twogether.app.repository.UserRepository;
import com.twogether.app.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

	@Override
	public User register(User user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        // Encriptar contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
	}

	@Override
	public Optional<User> login(String email, String password) {
		Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		return userRepository.findById(id)
				.map(existingUser -> {
	                if (updatedUser.getName() != null)
	                    existingUser.setName(updatedUser.getName());
	                if (updatedUser.getPhotoUrl() != null)
	                    existingUser.setPhotoUrl(updatedUser.getPhotoUrl());
	                if (updatedUser.getAboutMe() != null)
	                    existingUser.setAboutMe(updatedUser.getAboutMe());
	                if (updatedUser.getSkillToLearn() != null)
	                    existingUser.setSkillToLearn(updatedUser.getSkillToLearn());
	                if (updatedUser.getSkillToTeach() != null)
	                    existingUser.setSkillToTeach(updatedUser.getSkillToTeach());
	                if (updatedUser.getTeachingLevel() != null)
	                    existingUser.setTeachingLevel(updatedUser.getTeachingLevel());
	                return userRepository.save(existingUser);
	            })
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

	@Override
	public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
	}

	@Override
	public List<User> findIdealExchanges(Long userId) {
	    User authenticatedUser = userRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));
	    
	    String skillToLearn = authenticatedUser.getSkillToLearn();
	    String skillToTeach = authenticatedUser.getSkillToTeach();

	    List<User> idealExchanges = new ArrayList<>(getAllUsers().stream()
	            .filter(u -> !u.getId().equals(authenticatedUser.getId())) // excluir al usuario autenticado
	            .filter(u -> u.getSkillToTeach().equals(skillToLearn)) // enseñan lo que quiere aprender
	            .filter(u -> u.getSkillToLearn().equals(skillToTeach)) // buscan lo que él enseña
	            .toList());

	    return idealExchanges;
	}

	@Override
	public List<User> findSuggestedUsers(Long userId) {
	    User authenticatedUser = userRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	    String skillToLearn = authenticatedUser.getSkillToLearn();
	    String skillToTeach = authenticatedUser.getSkillToTeach();

	    List<User> suggestedUsers = getAllUsers().stream()
	            .filter(u -> !u.getId().equals(authenticatedUser.getId())) // excluir al usuario autenticado
	            .filter(u -> u.getSkillToTeach().equals(skillToLearn))    // enseñan lo que quiere aprender
	            .filter(u -> !u.getSkillToLearn().equals(skillToTeach))   // no buscan lo que él enseña
	            .toList();

	    return suggestedUsers;
	}

	@Override
	public List<User> findUsersICanHelp(Long userId) {
		User authUser = userRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	    String mySkillToTeach = authUser.getSkillToTeach();
	    String mySkillToLearn = authUser.getSkillToLearn();

	    List<User> potential = getAllUsers().stream()
	            .filter(u -> !u.getId().equals(userId)) // excluir al usuario autenticado
	            .filter(u -> u.getSkillToLearn().equals(mySkillToTeach)) // buscan aprender lo que yo enseño
	            .filter(u -> !u.getSkillToTeach().equals(mySkillToLearn)) // no enseñan lo que yo quiero aprender
	            .toList();

	    return potential;
	}
}
