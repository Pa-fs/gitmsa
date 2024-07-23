package org.problem_test;

public class Factorize {

    public static void main(String[] args) {
        factorize(20);
    }

    private static void factorize(int n) {

        if(n == 1) {
            return;
        }

        int factor = 2;

        while (n % factor != 0) {
            factor++;
        }
        System.out.println(factor);
        factorize(n / factor);
    }


}
