package com.example.demo.service.user;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.bo.user.CreateUserRequest;
import com.example.demo.bo.user.UpdateUserStatusRequest;
import com.example.demo.util.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest){
        UserEntity userEntity=userRepository.findById(userId).orElseThrow();
        if (!updateUserStatusRequest.getStatus().equals("ACTIVE") && !updateUserStatusRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("Error. The status must be either ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserStatusRequest.getStatus()));
        userRepository.save(userEntity);
    }



    @Override
    public List<String> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .filter(e -> e.getPassword().length() >8)
                .map(UserEntity ::getName)
                .collect(Collectors.toList());
    }
}
