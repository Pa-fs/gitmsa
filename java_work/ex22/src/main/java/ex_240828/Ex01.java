package ex_240828;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);

        System.out.println(ls);

        Consumer<List<Integer>> consumer = Collections::reverse;
        consumer.accept(ls);

        System.out.println(ls);

        ls.stream().forEach(s -> System.out.print(s + " "));

    }
}
