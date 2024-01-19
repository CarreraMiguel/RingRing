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

@Service ("UserService")
@Lazy
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

}
