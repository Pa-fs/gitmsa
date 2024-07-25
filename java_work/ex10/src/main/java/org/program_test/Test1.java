package org.program_test;

public class Test1 {

    public static void main(String[] args) {
        int num = 5;
        int total = 5;

        int[] answer = new int[num];
        int c = num*(num+1) / 2;
        int number = (total - c) / num + 1;

        System.out.println(c);
        System.out.println(number);


        int tmp = number;

        for(int i = (answer.length - 1) / 2; i >= 0; i--) {
            answer[i] = tmp--;
        }
        for(int i = (answer.length - 1) / 2; i < answer.length; i++) {
            answer[i] = number++;
        }

    }
}
