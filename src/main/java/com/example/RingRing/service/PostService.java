package com.example.RingRing.service;

import com.example.RingRing.api.iPostService;
import com.example.RingRing.models.Post;
import com.example.RingRing.models.dao.PostDao;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PostService")
@Lazy
public class PostService implements iPostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<PostDto> queryAllPosts(){
        return PostMapper.INSTANCE.toDTOList(this.postDao.findAll());
    }

    @Override
    public PostDto queryPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        Post finalPost = this.postDao.getReferenceById(post.getId());
        return PostMapper.INSTANCE.toDTO(finalPost);
    }
}
