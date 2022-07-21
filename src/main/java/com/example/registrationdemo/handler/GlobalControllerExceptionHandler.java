package com.example.registrationdemo.handler;


import com.example.registrationdemo.exceptions.GlobalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ModelAndView handleConflict() {
        ModelAndView model = new ModelAndView("hello");
        model.addObject("message", "Hello, Global Exception!");
        return model;
    }
}
