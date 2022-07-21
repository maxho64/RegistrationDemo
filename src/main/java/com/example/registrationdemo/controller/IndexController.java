package com.example.registrationdemo.controller;

import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.UserRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIndex(ModelMap map){
        map.addAttribute("userRegisterDto", new UserRegisterDto());
        map.addAttribute("userLoginDto", new UserLoginDto());
        return "index";
    }
}
