package com.example.RingRing.models.dto.mappers;

import com.example.RingRing.models.Commentary;
import com.example.RingRing.models.dto.CommentaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentaryMapper {

    CommentaryMapper INSTANCE = Mappers.getMapper(CommentaryMapper.class);
    CommentaryDto toDTO (Commentary commentary);
    List<CommentaryDto> toDTOList (List<Commentary> commentaries);
    Commentary toEntity(CommentaryDto commentaryDto);
}
