package ex07;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
//        String str = "123 + 456";
//        String[] arr = str.split(" ");
//        for (String s : arr) {
//            System.out.println(s);
//        }

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        // "[0-9]+" => 0~9까지 반복되는 숫자 체크
//        String str = s.replaceAll("[0-9]+", "A");
        String str = s.replaceAll("[ㄱ-ㅎㅏ-ㅣ가-힣]+", "");

        System.out.println(str);

        if(str.length() == 1 && Character.isDigit(str.charAt(0))) {
            System.out.println("숫자");
        } else {
            System.out.println("숫자 아님");
        }
    }
}
