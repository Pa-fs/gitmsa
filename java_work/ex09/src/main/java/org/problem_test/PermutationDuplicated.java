package org.problem_test;

import java.util.ArrayList;

public class PermutationDuplicated {

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        func(arr, new ArrayList<>(), 0);
    }

    private static void func(int[] arr, ArrayList<Integer> list, int lev) {
        if(lev == arr.length) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            func(arr, list, lev + 1);
            list.remove(list.size() - 1);
        }
    }
}
