package ex_240827;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ex05 {

    public static void main(String[] args) {

        Stream.of(1,2,3,4,5,6)
                .filter(n -> n%2 == 1)
                .forEach(s -> System.out.println("내용 " + s));


        List<Member> list = Arrays.asList(
                new Member(1, "홍길동", 20, "aaa@naver.com", "password"),
                new Member(2, "이길동", 30, "aaa@naver.com", "password"),
                new Member(3, "김길동", 40, "aaa@naver.com", "password")
        );

        // 나이에 최종합
        int sum = list.stream()
                .mapToInt(Member::getAge)
                .sum();

        System.out.println(sum);
        // 나이가 30이상인 사람 출력

        list.stream()
                .filter(n -> n.getAge() >= 30)
                .forEach(s -> {
                    System.out.println("내용 ");
                    System.out.println(s);
                });

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        list.stream()
                .filter(m -> m.getAge() >= 30)
                .forEach(m -> System.out.println(m));

    }
}
