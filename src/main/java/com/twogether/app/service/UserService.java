package com.twogether.app.service;

import java.util.List;
import java.util.Optional;

import com.twogether.app.model.User;

public interface UserService {

    User register(User user);

    Optional<User> login(String email, String password);

    User updateUser(Long id, User updatedUser);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteUser(Long id);
    
    List<User> findIdealExchanges(Long userId);
    
    List<User> findSuggestedUsers(Long userId);

    List<User> findUsersICanHelp(Long userId);
}
