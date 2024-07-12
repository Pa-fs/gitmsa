package Ex06;

import java.util.Arrays;

public class Ex08 {

    public static void main(String[] args) {
        String[] str = {"aa", "bb", "cc"};

        for (String s : str) {
            System.out.println(s);
        }
        int[] ar = {1,2,3,4,5};
        // 3가지
        System.out.println(Arrays.toString(ar));

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        for (int e : ar) {
            System.out.println(e);
        }
    }
}
