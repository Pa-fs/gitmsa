package ex08;

import java.util.Arrays;
import java.util.Scanner;

/*
Hello.java 문자열에서 파일명은 Hello 확장자인 java를 분리시켜보자

파일 업로드시에 exe 파일을 올릴 수 없도록 검사할 때
 */
public class Quiz1 {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next();

        String str = "Hello . Java";
        String[] arr = str.split("[A-Z]");
        System.out.println(Arrays.toString(arr));

        str = "안녕하세요1음...2특별히만들려고3하는건 없음";
        arr = str.split("\\d");
        System.out.println(Arrays.toString(arr));

        str = "안녕하세요1음...2특별히만들려고3하는건 없음";
        arr = str.split("\\D");
        System.out.println(Arrays.toString(arr));

//        String s = "";
//        String name = str.substring(0, str.indexOf("."));
//        String extendedName = str.substring(str.indexOf(".") + 1);
//
//        System.out.println(name);
//        System.out.println(extendedName);
    }
}
