package com.example.RingRing.api;

import com.example.RingRing.models.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> queryAllUsers();
    UserDto queryUser(UserDto userDto);
    int insertUser (UserDto userDto);
    int updateUser (UserDto userDto);
    int deleteUser (UserDto userDto);
    int addFriend(UserDto userDto);
    int removeFriend(UserDto userDto);
    List <UserDto> listFriends(UserDto userDto);
}
