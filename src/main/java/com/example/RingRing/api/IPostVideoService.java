package com.example.RingRing.api;

import com.example.RingRing.models.dto.PostVideoDto;

import java.util.List;

public interface IPostVideoService {
    List<PostVideoDto> queryAllPostVideos ();
    PostVideoDto queryPostVideo(PostVideoDto postVideoDto);
    int insertPostVideo (PostVideoDto postVideoDto);
    int updatePostVideo (PostVideoDto postVideoDto);
    int deletePostVideo(PostVideoDto postVideoDto);
}
