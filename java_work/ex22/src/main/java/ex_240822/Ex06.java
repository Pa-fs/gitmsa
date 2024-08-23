package ex_240822;

import java.util.Arrays;

public class Ex06 {

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};

        showAll(arr);
        showAll("TEST");
        showAll("TEST", "AAA");
        showAll("TEST", "AAA", "BBB");
    }

    public static void showAll(String ...args) {
        System.out.println(Arrays.toString(args));

    }
}
