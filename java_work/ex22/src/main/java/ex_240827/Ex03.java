package ex_240827;

import java.util.Arrays;

public class Ex03 {

    public static void main(String[] args) {
        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};

        Arrays.stream(arr, 1, 4)
                .forEach(s -> System.out.println(s));

    }
}