package ex08.aa;

public class Circle {
    public static final double PI = 3.1415;
    public static int a = 10;

    public static int doA() {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public void do둘레() {
        System.out.println(2*PI*a);
    }
}
