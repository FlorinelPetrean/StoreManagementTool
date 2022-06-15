package com.demo.StoreManagementTool.filters;

import com.demo.StoreManagementTool.model.entity.AppUser;
import com.demo.StoreManagementTool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Order(2)
public class AdminFilter extends OncePerRequestFilter {
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("Authorization");
        if(username != null) {
            AppUser user = userService.findByUsername(username);
            if (!user.getRole().equals("ADMIN")) {
                if(!request.getMethod().equals("GET")) {
                    response.setStatus(401);
                    response.getOutputStream().write("User is not admin! Operation is not permitted".getBytes());
                    return;
                }
            }
        }

        filterChain.doFilter(request, response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        if (path.equals("/user/login"))
            return true;
        return false;
    }
}

