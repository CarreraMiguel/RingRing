package com.example.RingRing.controller;

import com.example.RingRing.api.IPostVideoService;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostVideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postVideo")
public class PostVideoController {

    private final IPostVideoService postVideoService;

    public PostVideoController(IPostVideoService postVideoService) {
        this.postVideoService = postVideoService;
    }

    @GetMapping(value = "/testPostVideoController")
    public String test(){
        return ("PostVideo controller works!");
    }

    @GetMapping (value = "/getAll")
    public List<PostVideoDto> queryAllPostVideos(){
        return this.postVideoService.queryAllPostVideos();
    }

    @PostMapping(value = "/get")
    public PostVideoDto queryPostVideo(@RequestBody PostVideoDto postVideo){
        return this.postVideoService.queryPostVideo(postVideo);
    }

    @PostMapping (value = "/add")
    public int insertPostVideo(@RequestBody PostVideoDto postVideo){
        return this.postVideoService.insertPostVideo(postVideo);
    }

    @PutMapping (value = "/update")
    public int updatePostVideo(@RequestBody PostVideoDto postVideo){
        return this.postVideoService.updatePostVideo(postVideo);
    }

    @DeleteMapping (value = "/delete")
    public int deletePostVideo(@RequestBody PostVideoDto postVideo){
        return this.postVideoService.deletePostVideo(postVideo);
    }

    @PostMapping (value = "/create")
    public PostVideoDto createPostVideo(@RequestBody PostVideoDto postVideo, PostDto post){
        return this.postVideoService.createPostVideo(postVideo, post);
    }
}
