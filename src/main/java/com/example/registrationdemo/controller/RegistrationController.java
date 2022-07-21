package com.example.registrationdemo.controller;

import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.UserRegisterDto;
import com.example.registrationdemo.dto.mapper.UserMapper;
import com.example.registrationdemo.entities.User;
import com.example.registrationdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController{

    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public RegistrationController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(ModelMap map,
                               @Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            map.addAttribute("color", "red");
            map.addAttribute("message", "User is not registered!");
        } else {
            User user = mapper.toUser(userRegisterDto);
            service.save(user);
            map.addAttribute("color", "green");
            map.addAttribute("message", "User is registered!");
        }
        map.addAttribute("userLoginDto", new UserLoginDto());
        map.addAttribute("userRegisterDto", userRegisterDto);
        return "index";
    }

}
