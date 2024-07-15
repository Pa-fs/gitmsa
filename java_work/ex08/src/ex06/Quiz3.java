package ex06;

import java.util.Scanner;

/*
10진수 입력받아 -> 2진수
 */
public class Quiz3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 10 => 1010
        // 35 => 100011
        String res = "";
        while (n > 0) {
            res = res + (n % 2);
            n = n / 2;
        }
        int left = 0, right = res.length() - 1;
        char[] chArr = res.toCharArray();
        while (left < right) {
            char tmp = chArr[left];
            chArr[left] = chArr[right];
            chArr[right] = tmp;
            left++;
            right--;
        }

        System.out.println(new String(chArr));
    }
}
