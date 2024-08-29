package ex_240829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex01 {

    public static void main(String[] args) {
        Stream.of(11, 22, 33, 44, 55)
                .forEach(System.out::println);

        Stream.of("So Simple", "11,")
                .forEach(System.out::println);

        List<String> list1 = Arrays.asList("11","22","33","44");
        List<String> list2 = Arrays.asList("11","22","33","44");

        Stream.of(list1, list2).forEach(System.out::println);

        System.out.println("--------------------------");
        // flatMap N : 1으로 만듬
        Stream.of(list1, list2)
                .flatMapToInt(strings ->
                        strings.stream().mapToInt(
                                s-> Integer.parseInt(s)))
                .forEach(System.out::println);


        int result = Stream.of(list1, list2)
                .flatMapToInt(strings ->
                        strings.stream().mapToInt(
                                s -> Integer.parseInt(s)))
                .sum();
        System.out.println("result = " + result);

    }
}
