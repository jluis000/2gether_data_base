package com.twogether.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twogether.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
    List<User> findBySkillToTeach(String skillToLearn);
    List<User> findAll();
}
