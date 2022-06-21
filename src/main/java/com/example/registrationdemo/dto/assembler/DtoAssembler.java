package com.example.registrationdemo.dto.assembler;

import com.example.registrationdemo.dto.UserLoginDto;
import com.example.registrationdemo.dto.UserRegisterDto;
import jakarta.servlet.http.HttpServletRequest;



public class DtoAssembler {

    private final UserRegisterDtoAssembler userRegisterDtoAssembler = new UserRegisterDtoAssembler();
    private final UserLoginDtoAssembler userDtoAssembler = new UserLoginDtoAssembler();

    public void assemble(HttpServletRequest request){
        String path = request.getServletPath();
        if(path.equals(Paths.LOGIN_PATH)){
            UserLoginDto user = userDtoAssembler.assemble(request);
            request.setAttribute("user", user);
        } else if(path.equals(Paths.REGISTER_PATH)){
            UserRegisterDto user = userRegisterDtoAssembler.assemble(request);
            request.setAttribute("user", user);
        }
    }
}
