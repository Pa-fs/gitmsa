package ex02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 입력");
        int result = sc.nextInt();

        Fact fact = new Fact();
        int retValue = fact.aa(10);

        System.out.println("result = " + result);
        System.out.println("retValue = " + retValue);
    }
}
