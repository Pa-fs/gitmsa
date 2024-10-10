package com.pmh.org.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public LoginFilter(AuthenticationManager authenticationManager) {
        // post -> get 방식으로
        this.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }

    // 로그인 시도
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("로그인 시도");

//        사용자 요청을 가져오는 다른 방식
//        try {
//            JoinDto joinDto = new ObjectMapper().readValue(request.getInputStream(), JoinDto.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("email = " + email);
        System.out.println("password = " + password);

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, password);
        return authenticationManager.authenticate(token);
    }

    // 로그인 성공 ... jwt 토큰 발행
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {
        System.out.println("로그인 성공");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("로그인 성공");
    }

    // login fail -> username password 을 확인하세요
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        System.out.println("로그인 실패");
        response.setContentType("text/html; charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
                .write("이메일과 비밀번호를 확인하세요");
    }
}

