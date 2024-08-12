package example;

import java.util.Arrays;

public class Ex04 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,3,5,19,4};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
