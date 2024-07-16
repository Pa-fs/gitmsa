package ex08;

import java.util.Arrays;

public class Main {

    Main() {
        int[] answer = {1,4,4,3,1,4,4,2,1,3,2,5,9};
        int[] countNumber = {1,2,3,4,5,9};
        int[] starNumber = new int[countNumber.length];

        System.out.println(Arrays.toString(answer));
        doPrint(answer);
        System.out.println();

        for (int j = 0; j < countNumber.length; j++) {
            System.out.print(countNumber[j]);
            for (int i = 0; i < answer.length; i++) {
                if(countNumber[j] == answer[i]) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void doPrint(int[] temp) {
        System.out.print("[");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            if(i + 1 == temp.length)
                break;
            System.out.print(", ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        new Main();
    }
}
