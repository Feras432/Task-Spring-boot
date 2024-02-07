package com.example.demo.service;

import com.example.demo.bo.user.CreateUserRequest;
import com.example.demo.bo.user.UpdateUserRequest;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStatus(Long userId, UpdateUserRequest updateUserRequest);
}
