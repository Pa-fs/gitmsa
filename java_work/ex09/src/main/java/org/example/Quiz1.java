package org.example;

/*
1. int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최댓값,최솟값을 찾아서 반환하는 메소드를
각각 다음의 형태로 정의하자
public static int minValue(int[] arr){}
public static int maxValue(int[] arr){}

단 반복문을 사용할때 minValue의 정의에서는 일반적인 for문을 사용하고 maxValue의 정의에서는
새로운 for(enhanced for문)을 사용하기로 하자

 */
public class Quiz1 {

    public static void main(String[] args) {

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i+1;
        }

        int minValue = minValue(arr);
        int maxValue = maxValue(arr);

        System.out.println(minValue + " " + maxValue);
    }

    private static int minValue(int[] arr) {
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(val > arr[i]) {
                val = arr[i];
            }
        }
        return val;
    }

    private static int maxValue(int[] arr) {
        int val = Integer.MIN_VALUE;
        for (int elememnt : arr) {
            if(val < elememnt) {
                val = elememnt;
            }
        }
        return val;
    }
}
