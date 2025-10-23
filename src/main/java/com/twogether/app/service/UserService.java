package com.twogether.app.service;

import com.twogether.app.dto.UserDto;
import com.twogether.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    Optional<UserDto> getUserById(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);
    
    Optional<User> getUserByEmail(String email);
}