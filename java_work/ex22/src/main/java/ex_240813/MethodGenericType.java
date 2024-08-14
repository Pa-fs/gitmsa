package ex_240813;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodGenericType {

    // 첫번째 <T> 제네릭 메서드 타입을 표시 및 매개변수지정
    // 두번째 Box<T> 반환타입
    // 세번째 T 메서드 매개변수타입
    public static <T> Box<T> makeBox(T t) {
        Box<T> box = new Box<>();
        box.setObj(t);
        return box;
    }

    public static void main(String[] args) {
        Box<String> box1 = makeBox("test");
        Box<Integer> box2 = makeBox(20);

        System.out.println(box1);
        System.out.println(box2);

        List<String> list = Arrays.asList("홍길동", "길동", "동");
        List<Integer> ilist = list
                .stream()
                .mapToInt(String::length)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(ilist);
    }
}
