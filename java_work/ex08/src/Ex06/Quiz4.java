package Ex06;

import java.util.Scanner;

public class Quiz4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int left = 0, right = str.length() - 1;
        char[] chArr = str.toCharArray();
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
