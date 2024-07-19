package org.example;

/*
3. 다음 형태로 표현된 2차원 배열이 존재한다고 가정해보자
1   2    3   //1행
4   5    6   //2행
7   8    9   //3행
이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메소드를 정의하자
7   8    9   //1행
1   2    3   //2행
4   5    6   //3행


물론 배열의 가로와 세로길이에 상관없이 위와 같이 동작하도록 메소드를 정의해야 한다.

 */
public class Quiz3 {

    public static void main(String[] args) {

        int[][] arr = new int[3][3];

        int val = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = val++;
            }
        }
        // 0 2 swap
        // 1 2 swap
        for (int i = 0; i < arr.length - 1; i++) {
            int[] tmp = arr[i];
            arr[i] = arr[arr.length - 1];
            arr[arr.length - 1] = tmp;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
