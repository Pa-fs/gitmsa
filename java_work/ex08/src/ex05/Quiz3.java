package ex05;

import java.util.Scanner;

/*

3.
7개의 정수를 입력받아 내림차순으로 정렬하는 프로그램을 만들어라
사용자가
6,9,15,3,2,11,20 입력했다면
20,15,11,9,6,3,2 출력되어야 한다.
 */
public class Quiz3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // 버블정렬
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                if(arr[i] < arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }

        //선택정렬
//        for (int i = 0; i < arr.length; i++) {
//            int idx = i;
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j] > arr[idx]) {
//                    idx = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[idx];
//            arr[idx] = temp;
//
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println();
//        }

        // 삽입정렬
        // 5 2 7 1 4
        // 2
        //   5 7 1 4
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            for (j = i - 1; j >= 0 && arr[j] < val; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = val;

            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
