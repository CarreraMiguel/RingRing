package com.example.RingRing.service;

import com.example.RingRing.api.iPostVideoService;
import com.example.RingRing.models.PostVideo;
import com.example.RingRing.models.dao.PostVideoDao;
import com.example.RingRing.models.dto.PostVideoDto;
import com.example.RingRing.models.dto.mappers.PostVideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("PostVideoService")
@Lazy
public class PostVideoService implements iPostVideoService {
    @Autowired
    private PostVideoDao postVideoDao;

    @Override
    public List<PostVideoDto> queryAllPostVideos(){
        return PostVideoMapper.INSTANCE.toDTOList(this.postVideoDao.findAll());
    }

    @Override
    public PostVideoDto queryPostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        PostVideo finalPostVideo = this.postVideoDao.getReferenceById(postVideo.getId());
        return PostVideoMapper.INSTANCE.toDTO(finalPostVideo);
    }

    @Override
    public int insertPostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        this.postVideoDao.saveAndFlush(postVideo);
        return postVideo.getId();
    }

    @Override
    public int updatePostVideo (PostVideoDto postVideoDto){
        return this.insertPostVideo(postVideoDto);
    }

    @Override
    public int deletePostVideo(PostVideoDto postVideoDto){
        PostVideo postVideo = PostVideoMapper.INSTANCE.toEntity(postVideoDto);
        this.postVideoDao.delete(postVideo);
        return postVideo.getId();
    }
}
