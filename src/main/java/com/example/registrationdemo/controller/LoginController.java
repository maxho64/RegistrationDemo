package com.example.registrationdemo.controller;

import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.mapper.UserMapper;
import com.example.registrationdemo.entities.User;
import com.example.registrationdemo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {

    private UserService service;
    private UserMapper mapper;

    @Override
    public void init() {
        service = new UserService();
        mapper = new UserMapper();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/users";
        User user = mapper.toUser((UserLoginDto) request.getAttribute("user"));

        HttpSession session = request.getSession();
        boolean isRegistered = service.isRegistered(user);
        session.setAttribute("isAuth", isRegistered);

        if(!isRegistered){
            request.setAttribute("color", "red");
            request.setAttribute("message", "User not registered!");
            path = "index.jsp";
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    public void destroy() {
        service = null;
        mapper = null;
    }
}
