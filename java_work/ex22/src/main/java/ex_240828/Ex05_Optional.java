package ex_240828;

import java.util.Optional;

public class Ex05_Optional {

    public static void main(String[] args) {

        Optional<String> os1 = Optional.of("TOY1");

        System.out.println(os1);
        System.out.println(os1.get());

        Optional<Object> os3 = Optional.ofNullable(null);
        System.out.println(os3);
        os3.ifPresent(System.out::println);
        System.out.println("----------------------------");
        os3.ifPresentOrElse(System.out::println, () -> System.out.println("없음"));
    }
}
