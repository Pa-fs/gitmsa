package ex_240826;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex05 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(11,22,33,44,55,10,20,30,40,50);
        list = new ArrayList<>(list);
//        list.removeIf(i -> i % 10 != 0);

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0) {
                indexes.add(list.get(i));
            }
        }

        System.out.println(list);
        System.out.println(indexes);
    }
}
