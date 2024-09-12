package com.kty.ex07.freeboard;

import com.kty.ex07.user.User;
import com.kty.ex07.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FreeBoardRepositoryTest {

    // 스프링 컨테이너에서 freeBoardRepository 객체 가져오기
    @Autowired
    FreeBoardRepository freeBoardRepository;

    // 1. UserRepository
    // 2. Cascade JPA 속성 이용
    @Autowired
    UserRepository userRepository;

    @Test
    void insertTest() {

        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("d@naver.com")
                .password("password")
                .build();
//        userRepository.save(user);

        FreeBoard freeBoard = FreeBoard.builder()
                .title("제목")
                .content("내용")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }

    @Test
    void selectTest() {
        List<FreeBoard> freeBoardList = freeBoardRepository.findAll();
        freeBoardList.stream().forEach(System.out::println);
    }

    @Test
    void deleteTest() {
        freeBoardRepository.deleteById(1L);
    }

    @Test
    void updateTest() {
        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("dd@naver.com")
                .password("password")
                .build();
//        userRepository.save(user);

        FreeBoard freeBoard = FreeBoard.builder()
                .idx(3L)
                .title("제목제목")
                .content("내용내용")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }
}