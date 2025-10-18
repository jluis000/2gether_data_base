package com.twogether.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twogether.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
