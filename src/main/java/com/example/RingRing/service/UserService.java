package com.example.RingRing.service;

import com.example.RingRing.api.IUserService;
import com.example.RingRing.models.Post;
import com.example.RingRing.models.PostImage;
import com.example.RingRing.models.PostVideo;
import com.example.RingRing.models.User;
import com.example.RingRing.models.dao.UserDao;
import com.example.RingRing.models.dto.PostDto;
import com.example.RingRing.models.dto.PostImageDto;
import com.example.RingRing.models.dto.PostVideoDto;
import com.example.RingRing.models.dto.UserDto;
import com.example.RingRing.models.dto.mappers.PostImageMapper;
import com.example.RingRing.models.dto.mappers.PostMapper;
import com.example.RingRing.models.dto.mappers.PostVideoMapper;
import com.example.RingRing.models.dto.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto queryUser(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        User finalUser = this.userDao.getReferenceById(user.getId());
        return UserMapper.INSTANCE.toDTO(finalUser);
    }

    @Override
    public List<UserDto> queryAllUsers(){
        return UserMapper.INSTANCE.toDTOList(this.userDao.findAll());
    }

    @Override
    public int insertUser (UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        this.userDao.saveAndFlush(user);
        return user.getId();
    }
    @Override
    public int updateUser (UserDto userDto){
        return this.insertUser(userDto);
    }
    @Override
    public int deleteUser(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        this.userDao.delete(user);
        return user.getId();
    }
    @Override
    public int addFriend(UserDto newFriendId){
        User friend = UserMapper.INSTANCE.toEntity(newFriendId);
        Optional<User> friendExist = this.userDao.findById(friend.getId());
        if(friendExist.isPresent() && !friend.getFriendList().contains(friendExist.get())){
            friend.getFriendList().add(friendExist.get());
            return friendExist.get().getId();
        } else {
            throw new RuntimeException("Error: No se pudo agregar al amigo. Asegúrate de que el usuario exista y no esté ya en la lista de amigos.");
        }
    }

    @Override
    public int removeFriend(UserDto removedFriend){
        User friend = UserMapper.INSTANCE.toEntity(removedFriend);
        Optional<User> friendList = this.userDao.findById(friend.getId());
        if(friendList.isPresent() && friendList.get().getFriendList().contains(friend)){
                friendList.get().getFriendList().remove(friend);
            return friendList.get().getId();
        } else {
            throw new RuntimeException("Error: Asegurate de que el id coincida con el de tus amigos");
        }
    }

    @Override
    public List<UserDto> listFriends(UserDto userDto) {
        User user = UserMapper.INSTANCE.toEntity(userDto);

        List<UserDto> listOfFriends = new ArrayList<>();

        if(user.getFriendList().isEmpty()){
            throw new RuntimeException("Todavía no tienes ningún amigo");
        } else {
            for(User friends : user.getFriendList()){
                System.out.println("Nombre: " + friends.getName() + " Id: " + friends.getId());
                UserDto friendDto = UserMapper.INSTANCE.toDTO(friends);
                listOfFriends.add(friendDto);
            }
        }
        return listOfFriends;
    }

    @Override
    public List<PostDto> listPosts(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);

        List<PostDto> postDtos = new ArrayList<>();
        if(user.getPosts().isEmpty()){
            throw new RuntimeException("Este usuario todavía no ha creado ningún Post");
        } else {
            for(Post post : user.getPosts()){
                PostDto postDto = PostMapper.INSTANCE.toDTO(post);
                postDtos.add(postDto);
            }
        }
        return postDtos;
    }

    @Override
    public List<PostImageDto> listPostImages(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);

        List<PostImageDto> postImageDtos = new ArrayList<>();
        if(user.getPostImages().isEmpty()){
            throw new RuntimeException("Este usuario todavía no ha creado ningun Post con imagen");
        } else {
            for(PostImage postImage : user.getPostImages()){
                PostImageDto postImageDto = PostImageMapper.INSTANCE.toDTO(postImage);
                postImageDtos.add(postImageDto);
            }
        }
        return postImageDtos;
    }

    @Override
    public List<PostVideoDto> listPostVideos(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);

        List<PostVideoDto> postVideoDtos = new ArrayList<>();
        if(user.getPostVideos().isEmpty()){
            throw new RuntimeException("Este usuario no ha creado ningun Post de Video");
        } else {
            for(PostVideo postVideo : user.getPostVideos()){
                PostVideoDto postVideoDto = PostVideoMapper.INSTANCE.toDTO(postVideo);
                postVideoDtos.add(postVideoDto);
            }
        }
        return postVideoDtos;
    }


}
