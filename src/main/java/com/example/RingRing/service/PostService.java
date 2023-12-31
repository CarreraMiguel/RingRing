package com.example.RingRing.service;

import com.example.RingRing.api.IPostService;
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
public class PostService implements IPostService {
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

    @Override
    public int insertPost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        this.postDao.saveAndFlush(post);
        return post.getId();
    }

    @Override
    public int updatePost (PostDto postDto){
        return this.insertPost(postDto);
    }

    @Override
    public int deletePost(PostDto postDto){
        Post post = PostMapper.INSTANCE.toEntity(postDto);
        this.postDao.delete(post);
        return post.getId();
    }

}
