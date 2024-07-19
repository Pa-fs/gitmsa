package org.problem_test;

public class RecursiveStack {

    static String str = "";
    public static void main(String[] args) {

        int n = 10;

        recursiveStack(n);
        System.out.println(str);
    }

    private static void recursiveStack(int n) {
        if(n == 0) {
            return;
        }

        recursiveStack(n / 2);
        str = str + (n % 2);
    }
}
