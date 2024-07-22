package org.problem_test;

public class PowerSet {

    static boolean[] visited = new boolean[3];
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        f(arr, 0);
    }

    public static void f(int[] arr, int lev) {
        if(lev == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        visited[lev] = true;
        f(arr, lev + 1);
        visited[lev] = false;
        f(arr, lev + 1);
    }
}
