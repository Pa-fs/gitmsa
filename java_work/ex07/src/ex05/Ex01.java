package ex05;

public class Ex01 {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 6; j++) {
                if(i > 0) continue;
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
