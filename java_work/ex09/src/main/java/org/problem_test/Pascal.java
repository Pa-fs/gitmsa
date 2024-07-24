package org.problem_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        list.add(init);
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> prev = list.get(i - 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            list.add(temp);
        }

        System.out.println(list.get(n - 1).get(k - 1));

//        showList(list);
    }

//    private static void showList(List<List<Integer>> list) {
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.print(list.get(i).get(j) + "\t");
//            }
//            System.out.println();
//        }
//    }
}
