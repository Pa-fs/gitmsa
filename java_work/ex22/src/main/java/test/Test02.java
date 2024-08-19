package test;

import java.util.Arrays;

public class Test02 {

    public static int[] solution(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        System.out.println(Arrays.toString(clone));
        return clone;
    }
    public static void main(String[] args) {

        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }
}
