package com.munna.usermanagement.service;

import java.util.List;
import java.util.Optional;

import com.munna.usermanagement.entity.User;

public interface UserService {
    User saveUser(User user);   // unified create/update
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}