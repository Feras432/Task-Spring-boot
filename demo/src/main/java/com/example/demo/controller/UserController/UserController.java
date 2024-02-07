package com.example.demo.controller.UserController;

import com.example.demo.service.UserService;
import com.example.demo.bo.user.CreateUserRequest;
import com.example.demo.bo.user.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        try {
            userService.saveUser(createUserRequest);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("User created successfully");
    }
    @PutMapping("/updatedUserStatus")
    public ResponseEntity<String> updateUser(@RequestParam Long userId, @RequestBody UpdateUserRequest updateUserRequest){
        try {
            userService.updateUserStatus(userId, updateUserRequest);
        }catch(IllegalArgumentException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return  ResponseEntity.ok("User updated successfully");
    }
}
