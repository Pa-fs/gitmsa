package com.pmh.ex10.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
