package com.pmh.ex03.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // URL 매핑하는 클래스
@RequestMapping("user") // URL user로 시작
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("select")
    public List<User> select() {
        return userRepository.findAll();
    }

    // localhost:8080/user/insert
    @PostMapping("insert")
    public String insert(@RequestBody User user) {
//        User user = User.builder()
//                .name("홍길동")
//                .age(20)
//                .email("aaa@naver.com")
//                .password("password")
//                .wdate(LocalDateTime.now())
//                .build();

        userRepository.save(user);
        return "ok";
    }
}
