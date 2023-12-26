package com.example.RingRing.api;

import com.example.RingRing.models.dto.PostImageDto;

import java.util.List;

public interface iPostImageService {
    List<PostImageDto> queryAllPostImages ();
    PostImageDto queryPostImage(PostImageDto postImageDto);
    int insertPostImage (PostImageDto postImageDto);
    int updatePostImage (PostImageDto postImageDto);
    int deletePostImage(PostImageDto postImageDto);
}
