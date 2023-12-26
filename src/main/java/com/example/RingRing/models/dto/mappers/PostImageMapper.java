package com.example.RingRing.models.dto.mappers;

import com.example.RingRing.models.PostImage;
import com.example.RingRing.models.dto.PostImageDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostImageMapper {
    PostImageMapper INSTANCE = Mappers.getMapper(PostImageMapper.class);
    PostImageDto toDTO (PostImage postImage);
    List<PostImageDto> toDTOList (List<PostImage> postImages);
    PostImage toEntity (PostImageDto postImageDto);
}
