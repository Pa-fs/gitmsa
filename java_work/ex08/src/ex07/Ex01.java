package ex07;

import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        int[][] num = new int[4][3];

        System.out.println(num.length);
        System.out.println(num[0].length);
        System.out.println(num[1].length);
        System.out.println(num[2].length);
        System.out.println(num[3].length);

        int a = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = a++;
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < num.length; i++) {
            Arrays.fill(num[i], Integer.MIN_VALUE);
            System.out.println(Arrays.toString(num[i]));
        }
    }
}
