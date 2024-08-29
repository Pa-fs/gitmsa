package ex_240829;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex08 {

    public static void main(String[] args) {

        // 1,3,5,7,9
        List<Integer> list1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 1)
                .collect(
                        () -> new ArrayList<>(),
                        (list, item) -> list.add(item),
                        ((integers, integers2) -> integers.addAll(integers2))
                );

        System.out.println(list1);

        // 2,4,6,8,10
        List<Integer> list2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .toList();
        System.out.println(list2);

        // 중복제거 10,20,30,40,30 모으는거
        List<Integer> list3 = Stream.of(10, 20, 30, 40, 30)
                .distinct()
                .toList();

        System.out.println(list3);

        Set<Integer> mSet = Stream.of(10,20,30,10,40,30)
                .collect(
                        () -> new HashSet<>(),
                        (set, item) -> set.add(item),
                        (integers, integers2) -> {}
                );

        System.out.println(mSet);
    }
}
