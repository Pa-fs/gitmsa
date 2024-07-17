package ex09;

import java.util.Arrays;

public class Ex01 {

    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

//        answer = answer + my_string.substring(0, s);
//        answer = answer + overwrite_string;
//        answer = answer + my_string.substring(s + overwrite_string.length());
        char[] c_my_string = my_string.toCharArray();
        char[] c_overwrite_string = overwrite_string.toCharArray();

        System.arraycopy(c_overwrite_string, 0,
                c_my_string, s, overwrite_string.length());

        answer = new String(c_my_string);
        return answer;
    }

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();

        String res = ex01.solution("Program29b8UYP", "merS123", 7);
        System.out.println(res);
    }
}
