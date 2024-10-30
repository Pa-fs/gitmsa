package com.pmh.org.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

//@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    public SecurityFilter(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

//        Authentication authentication =
//                SecurityContextHolder
//                        .getContext()
//                        .getAuthentication();

        log.info("Security Filter...");

        String authorization = request.getHeader("Authorization");
        log.info("Security Filter : {}", authorization);


        if( authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = authorization.split("Bearer ")[1];
        String email = jwtUtils.getEmailFromJwt(jwt);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                User.builder()
                        .username(email)
                        .password("temp")
                        .roles("USER")
                        .build(), null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 지나가라...
        filterChain.doFilter(request, response);
    }
}
