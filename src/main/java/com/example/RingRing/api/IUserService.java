package com.example.RingRing.api;

import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostImageDto;
import com.example.RingRing.models.dto.PostVideoDto;
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
    List <PostDto> listPosts(UserDto userDto);
    List<PostImageDto> listPostImages(UserDto userDto);
    List<PostVideoDto> listPostVideos(UserDto userDto);
}
