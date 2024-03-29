package com.example.RingRing.controller;

import com.example.RingRing.api.IUserService;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostImageDto;
import com.example.RingRing.models.dto.PostVideoDto;
import com.example.RingRing.models.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

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

    @PostMapping (value = "/addFriend")
        public int addUser (@RequestBody UserDto friend){ return this.userService.addFriend(friend);}

    @DeleteMapping (value = "/deleteFriend")
        public int removeFriend (@RequestBody UserDto friend){
        return this.userService.removeFriend(friend);
    }

    @GetMapping (value = "/viewFriends")
        public List<UserDto> listFriends(@RequestParam UserDto userId) {
            return this.userService.listFriends(userId);
    }

    @GetMapping (value = "/getAllPosts")
    public List<PostDto> listPosts(@RequestBody UserDto user){
        return this.userService.listPosts(user);
    }
    @GetMapping (value = "/getAllVideos")
    public List<PostVideoDto> listPostVideos(@RequestBody UserDto user){
        return this.userService.listPostVideos(user);
    }
    @GetMapping (value = "/getAllImages")
    public List<PostImageDto> listPostImages(@RequestBody UserDto user){
        return this.userService.listPostImages(user);
    }
}
