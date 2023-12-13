package com.example.RingRing.models.dto.mappers;

import com.example.RingRing.models.User;
import com.example.RingRing.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDTO (User user);

    List<UserDto> toDTOList (List<User> users);

    User toEntity (UserDto userDto);

}
