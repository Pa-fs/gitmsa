package ex06;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            double random = Math.random() * 10 + 1;
//
//            System.out.println((int) random);
//        }

        // X X 1  0 2
        // X 1 X  1 1
        // 1 X X  2 0
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i + j == n - 1) {
//                    System.out.print("1 ");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

        // X 1 X  0 1
        // X X 1  1 2 // 1 0
        // X 1 X  2 1
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(j != 0 && Math.abs(i - j) == 1) {
                    System.out.print("1 ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
