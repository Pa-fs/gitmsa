package ex08;

import java.util.Arrays;

public class CopyArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int len = 10;
        int[] answer = Arrays.copyOf(arr, len);
        System.out.println(Arrays.toString(answer));
    }
}
