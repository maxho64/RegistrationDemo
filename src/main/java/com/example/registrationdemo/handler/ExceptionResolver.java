package com.example.registrationdemo.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver extends SimpleMappingExceptionResolver {

    public ExceptionResolver() {
        setWarnLogCategory(ExceptionResolver.class.getName());
    }

    @Override
    public String buildLogMessage(Exception e, HttpServletRequest req) {
        return "MVC exception: " + e.getLocalizedMessage();
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest req,
                                              HttpServletResponse resp, Object handler, Exception ex) {
        ModelAndView model = super.doResolveException(req, resp, handler, ex);
        model.addObject("url", req.getRequestURL());
        return model;
    }
}