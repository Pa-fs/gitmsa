package ex01;

public class Ex01 {

    public static void doA() {
        int i = 0;
        while (i < 10) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            i++;
        }
    }
    public static void main(String[] args) {
        doA();
    }
}