package ex07;

public class Main {

    public static void main(String[] args) {
        String str = "123 + 456";
        String[] arr = str.split(" ");
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
