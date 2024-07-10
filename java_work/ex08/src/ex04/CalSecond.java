package ex04;

import java.util.Scanner;

public class CalSecond {
    // 초를 입력받는 함수
    public int inputNumber() {
        System.out.println("초입력: ");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        return result;
    }

    // int를 넘겨주면 String을 반환하는 함수
    public String calculate(int second) {
        int h = second / 3600;
        int m = second / 60 % 60;
        int s = second % 60;

//        int m = (second % 3600) / 60;
//        int s = (second % 3600) % 60;
        return h + "시간 " + m + "분 " + s + "초";
    }

    // toString 은 생략되어진 문법이다...
//    public String toString() {
//        return "toString";
//    }
}
