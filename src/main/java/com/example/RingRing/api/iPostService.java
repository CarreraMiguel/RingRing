package com.example.RingRing.api;

import com.example.RingRing.models.dto.PostDto;

import java.util.List;

public interface iPostService {
    List<PostDto> queryAllPosts ();
    PostDto queryPost(PostDto postDto);
    int insertPost (PostDto postDto);
    int updatePost (PostDto postDto);
    int deletePost(PostDto postDto);
}
