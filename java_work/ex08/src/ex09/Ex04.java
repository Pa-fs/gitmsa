package ex09;

public class Ex04 {

    public static void main(String[] args) {
        String a = "asd";
        String b = "bsd";

        System.out.println(a+b);
        System.out.println(a.concat(b));

        System.out.println(a.compareToIgnoreCase("ASD"));
        System.out.println(a.compareTo("ASD"));
        System.out.println(a.compareTo("asd"));

        System.out.println(a.compareToIgnoreCase("ASDa"));

        int n = 10;
        String se = String.valueOf(n);
    }
}
