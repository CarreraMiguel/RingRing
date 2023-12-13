package com.example.RingRing.api;

import com.example.RingRing.models.dto.UserDto;

import java.util.List;

public interface iUserService {
    List<UserDto> queryAllUsers();
    UserDto queryUser(UserDto userDto);
    int insertUser (UserDto userDto);
    int updateUser (UserDto userDto);
    int deleteUser (UserDto userDto);
}
