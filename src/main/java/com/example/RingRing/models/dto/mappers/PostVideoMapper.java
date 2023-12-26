package com.example.RingRing.models.dto.mappers;

import com.example.RingRing.models.PostVideo;
import com.example.RingRing.models.dto.PostVideoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostVideoMapper {
    PostVideoMapper INSTANCE = Mappers.getMapper(PostVideoMapper.class);
    PostVideoDto toDTO (PostVideo postVideo);
    List<PostVideoDto> toDTOList (List<PostVideo> postVideos);
    PostVideo toEntity (PostVideoDto postVideoDto);
}
