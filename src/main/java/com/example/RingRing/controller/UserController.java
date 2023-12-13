package com.example.RingRing.controller;

import com.example.RingRing.api.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    iUserService userService;

    @GetMapping
    public String testController(@RequestBody String name){
        return ("test controller for Users works!" + name);
    }
}
