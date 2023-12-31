package com.example.RingRing.controller;

import com.example.RingRing.api.IPostVideoService;
import com.example.RingRing.models.dto.PostVideoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/postVideo")
public class PostVideoController {
    @Autowired
    IPostVideoService postVideoService;

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
}
