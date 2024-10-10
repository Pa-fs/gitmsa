package com.pmh.org.login;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDto joinDto) {
        log.info("joinDto, {}", joinDto);
        loginService.join(joinDto);
        return "success";
    }

    @GetMapping("/login")
    public void redirectWithPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {
        // login 으로 진행해라...
        response.sendRedirect("/login");
    }
}
