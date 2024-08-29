package ex_240829;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex04 {

    public static void main(String[] args) {

        Stream<String> ss1 = Stream.of("MY_AGE", "YOUR_LIFE");

        ss1
                .flatMap(s -> Arrays.stream(s.split("_")))
                .forEach(System.out::println);

        System.out.println();

        ss1 = Stream.of("MY_AGE", "YOUR_LIFE");
        ss1
                .flatMap(s -> Stream.of(s.split("_")))
                .forEach(System.out::println);
    }
}
