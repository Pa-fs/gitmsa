package ex_240829;

import java.util.stream.Stream;

public class Ex06 {

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5, 6)
                .peek(System.out::println)
                .sorted(((o1, o2) -> o2 - o1))
                .forEach(System.out::println);

        long count = Stream.of(10, 20, 5, 8, 9)
                .count();
        System.out.println(count);

        int max = Stream.of(10, 20, 5, 8, 9)
                .mapToInt(Integer::valueOf)
                .max()
                .orElse(0);

        System.out.println("max = " + max);

        Stream.of(10, 20, 5, 8, 9)
                .mapToInt(Integer::valueOf)
                .max()
                .ifPresent(value -> System.out.println("max = " + value));

    }
}
