package com.example.registrationdemo.dto.mapper;

import com.example.registrationdemo.dto.UserDto;
import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.UserRegisterDto;
import com.example.registrationdemo.entities.User;

public class UserMapper {

    public User toUser(UserLoginDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User toUser(UserRegisterDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDto toUserDto(User user){
        return new UserDto(user.getName(), user.getLogin(), user.getEmail());
    }

}
