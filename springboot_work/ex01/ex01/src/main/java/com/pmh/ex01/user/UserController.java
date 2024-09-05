package com.pmh.ex01.user;

import com.pmh.ex01.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/member")
@RequiredArgsConstructor
public class UserController {

    // getBean 함수로 가져오는거
    // 스프링 객체 담는 통에서 자동으로 가져오기
    private final MemberRepository memberRepository;


    @GetMapping("/insert")
    public String aa(
            @RequestParam(name = "name", defaultValue = "내이름") String name,
            @RequestParam(name = "age", defaultValue = "30") int age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        MemberRepository memberRepository = new MemberRepository();
        memberRepository.insert(name, age);
        return "memberTable 저장했습니다.";
    }
}
