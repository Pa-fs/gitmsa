package org.problem_test;

public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[4][4];

        int num = 1;
        int row = 0;


        show(arr);
    }

    public static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
