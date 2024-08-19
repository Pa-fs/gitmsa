package ex_240819;

import java.util.Arrays;
import java.util.List;

public class Ex03 {

    public static void main(String[] args) {
        // immutable object
        List<String> list = Arrays.asList("TOY", "BOX", "ROBOT");

        /*
            list = new ArrayList<>(list);
            새로 객체를 생성하면 add 가능
         */

        list.add("add 불가능");

        System.out.println(list);
    }
}
