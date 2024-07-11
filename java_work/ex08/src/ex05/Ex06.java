package ex05;

public class Ex06 {

    public static void main(String[] args) {
        /*
            String -> char[]
            char[] -> String
         */
        String s = "STRING";
        char[] arr = s.toCharArray();
        System.out.println("문자열=" + s);
        System.out.println("배열" + String.valueOf(arr));

        arr[3] = '굿';

        System.out.println(new String(arr));
        System.out.println((int)arr[3]);
    }
}
