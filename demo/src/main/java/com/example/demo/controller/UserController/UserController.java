package com.example.demo.controller.UserController;

import com.example.demo.service.UserService;
import com.example.demo.user.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("User created successfully");
    }
}
