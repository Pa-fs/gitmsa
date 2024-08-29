package ex_240827;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {

        int[] ar = {1, 2, 3, 4, 5};

        int res = Arrays.stream(ar)
                .filter(i -> i % 2 == 1)
                .sum();

        System.out.println(res);
    }
}
