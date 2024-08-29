package ex_240827;

import java.util.Arrays;

public class Ex02 {

    public static void main(String[] args) {
        String[] arr = {"YOON", "PARK", "ROBOT"};

        /*
        1. stream 생성방법
        2. 중간연산 filter, map
        3. 최종연산 sum foreach
         */

        Arrays.stream(arr)
//                .mapToInt(s -> s.length())
//                .sum();
                .forEach(i -> System.out.println("내용 " + i));
    }
}
