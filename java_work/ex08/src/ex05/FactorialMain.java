package ex05;

import java.util.Scanner;

class Factorial {
    public int fact(int n) {
        if(n == 0) {
            return 1;
        }
        return 2 * fact(n - 1);
    }
}

public class FactorialMain {

    public static void main(String[] args) {
        /*
        String -> int Integer.parseInt(String str)
        int -> String 10 + ""
        문자열 입력 => scanner.nextLine()
        숫자 입력 => scanner.nextInt()
         */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);

        // 클래스의 정의와 인스턴스화
        Factorial f = new Factorial();
        int res = f.fact(n);
        System.out.println(res);
    }
}
