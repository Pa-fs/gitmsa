package test;

import java.util.Collections;
import java.util.TreeSet;

public class Test04 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }

        for (int n : result) {
            System.out.println(n);
        }
    }
}
