package com.example.RingRing.controller;

import com.example.RingRing.api.iCommentaryService;
import com.example.RingRing.models.dto.CommentaryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentary")
public class CommentaryController {
    @Autowired
    iCommentaryService commentaryService;

    @GetMapping( value = "/testCommentaryController")
    public String test(){
        return ("Commentary controller works!");
    }

    @GetMapping (value = "getAll")
    public List<CommentaryDto> queryAllCommentaries(){
        return this.commentaryService.queryAllCommentaries();
    }

    @PostMapping(value = "/get")
    public CommentaryDto queryCommentary(@RequestBody CommentaryDto commentary){
        return this.commentaryService.queryCommentary(commentary);
    }

    @PostMapping (value = "/add")
    public int insertCommentary(@RequestBody CommentaryDto commentary){
        return this.commentaryService.insertCommentary(commentary);
    }

    @PutMapping (value = "/update")
    public int updateCommentary(@RequestBody CommentaryDto commentary){
        return this.commentaryService.updateCommentary(commentary);
    }

    @DeleteMapping (value = "/delete")
    public int deleteCommentary(@RequestBody CommentaryDto commentary){
        return this.commentaryService.deleteCommentary(commentary);
    }
}
