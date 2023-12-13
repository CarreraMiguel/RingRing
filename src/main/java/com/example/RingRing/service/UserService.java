package com.example.RingRing.service;

import com.example.RingRing.api.iUserService;
import com.example.RingRing.models.User;
import com.example.RingRing.models.dao.UserDao;
import com.example.RingRing.models.dto.UserDto;
import com.example.RingRing.models.dto.mappers.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("UserService")
@Lazy
public class UserService implements iUserService {
    @Autowired
     private UserDao userDao;

    @Override
    public UserDto queryUser(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        User userFinal = this.userDao.getReferenceById(user.getId());
        return UserMapper.INSTANCE.toDTO(userFinal);
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

    public int updateUser (UserDto userDto){
        return this.insertUser(userDto);
    }

    public int deleteUser(UserDto userDto){
        User user = UserMapper.INSTANCE.toEntity(userDto);
        this.userDao.delete(user);
        return user.getId();
    }

}
