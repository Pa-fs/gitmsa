package ex20_try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("a : ");
            int a = scanner.nextInt();
            System.out.println("b : ");
            int b = scanner.nextInt();

            System.out.println(a/b);

            int[] c = new int[3];
            System.out.println(c[4]);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (InputMismatchException ie) {
            System.out.println(ie.getMessage());
            System.out.println("문자 넣으면 안되요 ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("이것은 모든 예외 상황");
        }

        System.out.println("정상 종료 되었씁니다");
    }

}
