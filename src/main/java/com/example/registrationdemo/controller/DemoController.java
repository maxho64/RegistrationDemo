package com.example.registrationdemo.controller;


import com.example.registrationdemo.exceptions.GlobalException;
import com.example.registrationdemo.exceptions.LocalException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class DemoController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getHello(@PathVariable("id") Integer id,  ModelMap map){
        switch (id){
            case 1:
                throw new GlobalException();
            case 2:
                throw new LocalException();
            case 3:
                throw new RuntimeException();
            default:
                map.addAttribute("message", "Hello, Spring MVC!");
                return "hello";
        }
    }

    @ExceptionHandler(LocalException.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView model = new ModelAndView("hello");
        model.addObject("message", "Hello, Local Exception!");
        return model;
    }
}
