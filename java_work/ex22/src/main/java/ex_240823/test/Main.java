package ex_240823.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cart = new int[n + 1];

        for (int i = 0; i < n; i++) {
            cart[i + 1] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();

            int tmp = cart[t1];
            cart[t1] = cart[t2];
            cart[t2] = tmp;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(cart[i] + " ");
        }
    }
}
