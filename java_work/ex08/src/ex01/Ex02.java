package ex01;

public class Ex02 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i+1) + (j+1) == 6) {
                    System.out.print((i+1) + " " + (j+1) + " ");
                }
            }
            System.out.println();
        }
    }
}
