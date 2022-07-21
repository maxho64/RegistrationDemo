package com.example.registrationdemo.controller;

import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.mapper.UserMapper;
import com.example.registrationdemo.entities.User;
import com.example.registrationdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public LoginController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getLoginPage(HttpServletRequest request, UserLoginDto userLoginDto) {
        User user = mapper.toUser(userLoginDto);
        logger.info("Try to get users for user {}", user);
        HttpSession session = request.getSession();
        boolean isRegistered = service.isRegistered(user);
        session.setAttribute("isAuth", isRegistered);

        if(!isRegistered){
            logger.warn("User {} is not registered", user);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("color", "red");
            modelAndView.addObject("message", "User not registered!");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        logger.debug("Move to {} url for user {}", "/users", user);
        return new ModelAndView("redirect:/users");
    }

}
