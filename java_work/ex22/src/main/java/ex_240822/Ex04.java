package ex_240822;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex04 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("BOX");
        list.add("ROBOT");
        list.add("TEST");

        int idx = Collections.binarySearch(list, "ROBOT");

        System.out.println(idx);
        System.out.println(list.get(idx));
    }
}
