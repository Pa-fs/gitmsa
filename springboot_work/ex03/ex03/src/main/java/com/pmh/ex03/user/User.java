package com.pmh.ex03.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT 설정
    private Long idx;
    // JPA CLASS -> table CREATE가 됩니다

    private String name;
    private int age;

    private String email;
    private String password;

    private LocalDateTime wdate;
}
/*
    @Configuration -> 객체 담는 통 정의
    @Bean -> 객체
    @Component -> 객체
    @ComponentScan -> 패키지 내용 읽어서 Component 및 Bean 객체 주입
    @Autowired -> new 예약어 안쓰고 객체 할당

 */
