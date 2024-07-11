package ex05;

import java.util.Scanner;

public class Quiz1 {
    /*
    1. 길이가 10인 배열을 선언하고 총 10개의 정수를 입력받아서,
    홀수와 짝수를 구분 지어 출력하는 프로그램을 작성해 보자.
    일단 홀수부터 출력하고 나서 짝수를 출력하도록 하자.
    단, 10개의 정수는 main 함수 내에서 입력받도록 하고,
    배열 내에 존재하는 홀수만 출력하는 함수와 배열 내에 존재하는 짝수만 출력하는 함수를 각각 정의해서
     이 두 함수를 호출하는 방식으로 프로그램을 완성하자.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        oddMethod(arr);
        evenMethod(arr);
    }
    private static void oddMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void evenMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
