package org.problem_test;

import java.util.ArrayList;
import java.util.List;

public class KtimesStrings {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
//        String[] arr = {
//                ".xx...xx.",
//                "x..x.x..x",
//                "x...x...x",
//                ".x.....x.",
//                "..x...x..",
//                "...x.x...",
//                "....x...."
//        };

        String[] arr = {
                "x.x",
                ".x.",
                "x.x"
        };
        int k = 3;
        for (String str : arr) {
            String tmp = "";
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < k; j++) {
                    tmp = tmp + str.charAt(i);
                }
            }

            for (int i = 0; i < k; i++) {
                res.add(tmp);
            }
        }

        for (String str : res) {
            System.out.println(str);
        }
    }
}