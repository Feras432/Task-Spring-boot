package com.example.demo.service.user;

import com.example.demo.bo.user.CreateUserRequest;
import com.example.demo.bo.user.UpdateUserStatusRequest;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest);
    List<String> getAllUsers();

}
