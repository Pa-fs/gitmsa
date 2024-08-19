package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test01 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<Integer> list2 = new ArrayList<>(list);
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);

        list3.remove(list.size() - 1);
        System.out.println(list3);

        int[] arr = {1, 2, 4, 5, 3,};
        System.out.println(arr.length);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3));
        System.out.println(list4.size());
        System.out.println(list4.isEmpty());
        Collections.sort(list4);
        System.out.println(list4);
    }
}
