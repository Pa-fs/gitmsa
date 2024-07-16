package ex08;

import java.util.Scanner;

/*
Hello.java 문자열에서 파일명은 Hello 확장자인 java를 분리시켜보자
 */
public class Quiz1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

//        String[] arr = str.split("\\.");
//        for(String s : arr) {
//            System.out.println(s);
//        }

        String s = "";
        String name = str.substring(0, str.indexOf("."));
        String extendedName = str.substring(str.indexOf(".") + 1);

        System.out.println(name);
        System.out.println(extendedName);
    }
}
