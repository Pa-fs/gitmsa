package org.program_test;

public class Test {

    public static void main(String[] args) {
        int[][] arr = {
                {572, 22, 37, 11},
                {287, 726, 384, 1},
        };

        int[][] answer = {};
        int rowLen = arr.length;
        int colLen = arr[0].length;
        if(rowLen - colLen > 0) {
            answer = fillMap(arr, rowLen - colLen, false);
        } else if(rowLen - colLen < 0) {
            answer = fillMap(arr, colLen - rowLen, true);
        }

        show(answer);
    }

    private static void show(int[][] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] fillMap(int[][] arr, int diff, boolean isRowAndCol) {
        int[][] res = new int[arr.length][];
        System.out.println(diff);
        // col
        if(!isRowAndCol) {
            for(int i = 0; i < arr.length; i++) {
                res[i] = new int[arr.length];
            }

            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[i].length; j++) {
                    res[i][j] = arr[i][j];
                }
            }
        }
        // row
        else {
            res = new int[arr.length + diff][arr.length + diff];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    res[i][j] = arr[i][j];
                }
            }
        }

        return res;
    }
}
