package ex_240902;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cake cake;

        int input = scanner.nextInt();

        switch (input) {

            case 1:
                cake = new CheeseCake();
                cake.bake();
                break;
            case 2:
                cake = new TemarmisuCake();
                cake.bake();
                break;
            default:
                break;
        }

    }
}
