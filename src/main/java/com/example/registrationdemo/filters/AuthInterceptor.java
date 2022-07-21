package com.example.registrationdemo.filters;

import com.example.registrationdemo.dto.assembler.Paths;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws IOException {
        if(!isAuth(request)){
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }
        return true;
    }

    private boolean isAuth(HttpServletRequest request){
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        Boolean isAuth = (Boolean) session.getAttribute("isAuth");
        return  Boolean.TRUE.equals(isAuth)
                || path.equals(Paths.LOGIN_PATH)
                || path.equals(Paths.REGISTER_PATH)  || path.equals(Paths.INDEX);
    }


}
