package com.example.RingRing.controller;

import com.example.RingRing.api.IPostService;
import com.example.RingRing.models.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

     private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping (value = "/testPostController")
    public String test(){
        return ("Post controller works!");
    }

    @GetMapping (value = "/getAll")
    public List<PostDto> queryAllPosts(){
        return this.postService.queryAllPosts();
    }

    @PostMapping (value = "/get")
    public PostDto queryPost(@RequestBody PostDto post){
        return this.postService.queryPost(post);
    }

    @PostMapping (value = "/add")
    public int insertPost(@RequestBody PostDto post){
        return this.postService.insertPost(post);
    }

    @PutMapping (value = "/update")
    public int updatePost(@RequestBody PostDto post){
        return this.postService.updatePost(post);
    }

    @DeleteMapping (value = "/delete")
    public int deletePost(@RequestBody PostDto post){
        return this.postService.deletePost(post);
    }

}
