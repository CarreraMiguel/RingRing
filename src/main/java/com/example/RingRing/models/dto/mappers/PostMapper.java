package com.example.RingRing.models.dto.mappers;

import com.example.RingRing.models.Post;
import com.example.RingRing.models.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    PostDto toDTO (Post post);
    List<PostDto> toDTOList (List<Post> posts);

    Post toEntity (PostDto postDto);
}
