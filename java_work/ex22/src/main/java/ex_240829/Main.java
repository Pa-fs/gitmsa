package ex_240829;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // List 1,2,3,4,5,6,7,8,9 생성해서 스트림으로 만들어 가지고
        // 1. 그냥 출력
        // 2. 홀, 짝 sum 총합 출력하기

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int res = list.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i)
                .sum();

        System.out.println(res);

        Integer reduce = list.stream()
                .reduce(0, ((integer, integer2) -> integer + integer2));

        // a = 0, b = 1
        // a = 1, b = 2
        // a = 3, b = 3
        // a = 6, b = 4
        System.out.println(reduce);
    }
}
