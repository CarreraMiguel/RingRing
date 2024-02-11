package com.example.RingRing.service;

import com.example.RingRing.api.IUserService;
import com.example.RingRing.models.User;
import com.example.RingRing.models.dao.UserDao;
import com.example.RingRing.models.dto.UserDto;
import com.example.RingRing.models.dto.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        for (int i = 0; i < user.getFriendList().size(); i++) {
            User friend = user.getFriendList().get(i);
            System.out.println((i + 1) + "Nombre del amigo: " + friend.getName() + "id: " + friend.getId());
        }
        return null;
    }

}
