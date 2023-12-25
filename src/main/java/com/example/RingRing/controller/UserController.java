package com.example.RingRing.controller;

import com.example.RingRing.api.iUserService;
import com.example.RingRing.models.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    iUserService userService;

    @GetMapping (value = "/testUserController")
    public String testController(){
        return ("test controller for Users works!");
    }

    @GetMapping (value = "/getAll")
        public List<UserDto> queryAllUsers(){
        return this.userService.queryAllUsers();
    }

    @PostMapping(value = "/get")
        public UserDto queryUser(@RequestBody UserDto user){
        return this.userService.queryUser(user);
    }

    @PostMapping (value = "/add")
        public int insertUser(@RequestBody UserDto user){
        return this.userService.insertUser(user);
    }

    @PutMapping (value = "/update")
        public int updateUser(@RequestBody UserDto user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping (value = "/delete")
    public int deleteUser (@RequestBody UserDto user){
        return this.userService.deleteUser(user);
    }

}
