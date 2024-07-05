package ex04;

import java.util.Scanner;

public class Ex01 {

    private static void doA(int end) {
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }

    private static void doB(int end) {
        int fact = 1;
        for (int i = 1; i <= end; i++) {
            fact = fact * i;
        }
        System.out.println(fact);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇까지 더할까여? ");
        int test = scanner.nextInt();
        doA(test);
        doB(test);
    }
}
