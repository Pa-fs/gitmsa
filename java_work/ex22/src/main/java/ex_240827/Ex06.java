package ex_240827;

import java.util.Arrays;
import java.util.List;

public class Ex06 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "FFFFFF", "BBB", "DDDDD");

        String result = list.stream()
                .reduce("EEEEEEEE", (a, b) -> {
                    if (a.length() > b.length()) return a;
                    else return b;
                });

        System.out.println(result);
        /*
            1. 생성
            2. 중간연산
                map, filter, sorted
            3. sum, foreach, reduce
         */


        result = list.stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
                .reduce("", (a, b) -> a + b);

        System.out.println(result);
    }
}
