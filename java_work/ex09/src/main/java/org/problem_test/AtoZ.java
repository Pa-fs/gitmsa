package org.problem_test;

import java.util.Scanner;

/*
    n 입력받아서
    a
    ~
    z
    aa
    ab
    ac
    ~
    zz

    n 길이만큼 출력

    n = 3

    a
    ~
    z

    aa
    ab
    ac
    ~
    zz

    aaa
    aab
    aac
    ~
    zzz
 */
public class AtoZ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("starting n value = " + i);
            recursive(i, "");
        }

    }

    private static void recursive(int lev, String str) {
        if(lev == 0) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < 26; i++) {
            recursive(lev - 1, str + (char)('a' + i));
        }
    }
}
