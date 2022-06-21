package com.example.registrationdemo.filters;


import com.example.registrationdemo.dto.assembler.Paths;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter  implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!isAuth((HttpServletRequest) request)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }

    private boolean isAuth(HttpServletRequest request){
        HttpSession session = request.getSession();
        String path = request.getServletPath();
        Boolean isAuth = (Boolean) session.getAttribute("isAuth");
        return  Boolean.TRUE.equals(isAuth)
                || path.equals(Paths.LOGIN_PATH)
                || path.equals(Paths.REGISTER_PATH);
    }


}
