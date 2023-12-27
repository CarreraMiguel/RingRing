package com.example.RingRing.controller;

import com.example.RingRing.api.iPostImageService;
import com.example.RingRing.models.dto.PostImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (name = "/postImage")
public class PostImageController {
    @Autowired
    iPostImageService postImageService;

    @GetMapping(value = "/testPostImageController")
    public String test(){
        return ("PostImage controller works!");
    }

    @GetMapping (value = "/getAll")
    public List<PostImageDto> queryAllPostImages(){
        return this.postImageService.queryAllPostImages();
    }

    @PostMapping(value = "/get")
    public PostImageDto queryPostImage(@RequestBody PostImageDto postImage){
        return this.postImageService.queryPostImage(postImage);
    }

    @PostMapping (value = "/add")
    public int insertPostImage(@RequestBody PostImageDto postImage){
        return this.postImageService.insertPostImage(postImage);
    }

    @PutMapping (value = "/update")
    public int updatePostImage(@RequestBody PostImageDto postImage){
        return this.postImageService.updatePostImage(postImage);
    }

    @DeleteMapping (value = "/delete")
    public int deletePostImage(@RequestBody PostImageDto postImage){
        return this.postImageService.deletePostImage(postImage);
    }
}
