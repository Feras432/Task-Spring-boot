package com.example.demo.controller;

import com.example.demo.bo.CreateContactRequest;
import com.example.demo.bo.CreateFarewellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/API/A-Z/")

public class CodedController {

    List<CreateContactRequest> allContact = new ArrayList<>();
    @GetMapping("/sayHi")
    public String sayHi(){
        return "Hello from spring boot";
   }

    @GetMapping("/greet")
    @ResponseBody
    public String greet(@RequestParam String name){
        return "Hello, " + name;
    }
    @PostMapping("/farewell")
    public String farewell(@RequestBody CreateFarewellRequest createFarewellRequest){
        return "Goodbye, " + createFarewellRequest.getName();
    }
    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody CreateContactRequest createContactRequest){
        for(int i=0; i<allContact.size(); i++){
          if (allContact.get(i).getEmail().equals(createContactRequest.getEmail())){
              return ResponseEntity.badRequest().body("Contact already exists");
          }

        }
        allContact.add(createContactRequest);
        return ResponseEntity.ok("Contact added successfully!");
    }
    @GetMapping("/getContactDetails")
    public ResponseEntity<?> getContactDetails(@RequestParam String name){
        for (int i=0;i<allContact.size();i++){
            if (allContact.get(i).getName().equals(name)){
                return ResponseEntity.ok(allContact.get(i));
            }
        }
        return ResponseEntity.badRequest().body("Contact not found");
    }
}
