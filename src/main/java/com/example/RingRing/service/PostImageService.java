package com.example.RingRing.service;

import com.example.RingRing.api.IPostImageService;
import com.example.RingRing.models.PostImage;
import com.example.RingRing.models.dao.PostImageDao;
import com.example.RingRing.models.dto.PostImageDto;
import com.example.RingRing.models.dto.mappers.PostImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PostImageService")
@Lazy
public class PostImageService implements IPostImageService {

    @Autowired
    private PostImageDao postImageDao;

    @Override
    public List<PostImageDto> queryAllPostImages(){
        return PostImageMapper.INSTANCE.toDTOList(this.postImageDao.findAll());
    }

    @Override
    public PostImageDto queryPostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        PostImage finalPostImage = this.postImageDao.getReferenceById(postImage.getId());
        return PostImageMapper.INSTANCE.toDTO(finalPostImage);
    }

    @Override
    public int insertPostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        this.postImageDao.saveAndFlush(postImage);
        return postImage.getId();
    }

    @Override
    public int updatePostImage (PostImageDto postImageDto){
        return this.insertPostImage(postImageDto);
    }

    @Override
    public int deletePostImage(PostImageDto postImageDto){
        PostImage postImage = PostImageMapper.INSTANCE.toEntity(postImageDto);
        this.postImageDao.delete(postImage);
        return postImage.getId();
    }
}
