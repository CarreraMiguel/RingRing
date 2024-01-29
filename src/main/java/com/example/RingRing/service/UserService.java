package com.example.RingRing.service;

import com.example.RingRing.api.IUserService;
import com.example.RingRing.models.User;
import com.example.RingRing.models.dao.UserDao;
import com.example.RingRing.models.dto.UserDto;
import com.example.RingRing.models.dto.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
     private UserDao userDao;

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
}
