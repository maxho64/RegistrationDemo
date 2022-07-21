package com.example.registrationdemo.controller;

import com.example.registrationdemo.dto.UserDto;
import com.example.registrationdemo.dto.mapper.UserMapper;
import com.example.registrationdemo.entities.User;
import com.example.registrationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(ModelMap map)  {
        Collection<User> users = service.getAll();
        List<UserDto> userDtoList = users.stream().map(mapper::toUserDto)
                .collect(Collectors.toList());
        map.addAttribute("users", userDtoList);
        return "users";
    }


}
