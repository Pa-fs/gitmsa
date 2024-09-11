package com.kty.ex04.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("select")
    public List<User> select(){
        return userRepository.findAll();
    }

    @PostMapping("insert")
    public String insert(@Valid @RequestBody UserReqDto userReqDto
//            ,@RequestParam(name = "aa") String aa
    ){
        System.out.println("실행");
        // save insert 실행...
//        User user = User.builder()
//                .name("홍길동")
//                .age(20)
//                .email("aaa@naver.com")
//                .password("password")
//                .wdate(LocalDateTime.now())
//                .build();
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);

        userRepository.save(user);
        return "ok";
    }

    @DeleteMapping("delete/{idx}")
    public String delete(@PathVariable("idx") Long idx) {
        System.out.println(idx);
        userRepository.deleteById(idx);
        return "deleted";
    }
}
