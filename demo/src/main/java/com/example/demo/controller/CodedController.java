package com.example.demo.controller;

import com.example.demo.bo.CreateFarewellRequest;
import org.springframework.web.bind.annotation.*;

@RestController("/API/A-Z/")

public class CodedController {
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
}
