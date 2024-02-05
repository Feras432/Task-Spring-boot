package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.user.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity= new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhonenumber(createUserRequest.getPhonenumber());
        userRepository.save(userEntity);

    }
}
