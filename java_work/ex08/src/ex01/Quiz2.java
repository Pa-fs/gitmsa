package ex01;

public class Quiz2 {

    public static void main(String[] args) {
        go(3);
    }

    public static void go(int n) {
        if(n == 0) {
            return;
        }

        System.out.println("*");
        go(n - 1);
        go(n - 1);
    }
}
