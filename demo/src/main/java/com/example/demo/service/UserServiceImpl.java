package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.bo.user.CreateUserRequest;
import com.example.demo.bo.user.UpdateUserRequest;
import com.example.demo.util.enums.Status;
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
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);

    }


    @Override
    public void updateUserStatus(Long userId, UpdateUserRequest updateUserRequest){
        UserEntity userEntity=userRepository.findById(userId).orElseThrow();
        if (!updateUserRequest.getStatus().equals("ACTIVE") && !updateUserRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("Error. The status must be either ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userRepository.save(userEntity);
    }
}
