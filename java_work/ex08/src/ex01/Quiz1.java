package ex01;

import java.util.Scanner;

/**
 * 1. 2의 n승을 구하는 함수를 재귀적으로 구현해 보자.
 * 그리고 그에 따른 적절한 함수를 구현해 보자.
 * 참고로 재귀 함수의 구현이 처음에는 어려운 편이기 때문에 여기서는 쉬운 문제를 제시하였다
 *
 * 2. 프로그램 사용자로부터 초(second)를 입력받은 후에,
 *  이를 [시, 분, 초]의 형태로 출력하는 프로그램을 작성해 보자.
 *
 * 3. 필자가 좋아하는 것 중 하나가 금요일 저녁 퇴근길에 DVD나 만화책을 잔뜩 빌리고,
 * 동네 슈퍼에 들러서 군것질거리를 사 가지고 집에 들어가는 것이다.
 * 오늘은 금요일이다. 현재 필자의 주머니에는 5천 원이 있다.
 * DVD 한 편을 빌리면 3,500원이 남는다.
 * 슈퍼에 들려서 크림빵(500원), 새우깡(700원), 콜라(400원)를 사려한다.
 * 잔돈을 하나도 남기지 않고 이 세 가지 물건을 하나 이상 반드시 구매하려면
 * 어떻게 구매를 진행해야 하겠는가? 물론 여기에는 여러 가지 경우의 수가 있을 것이다.
 *
 * 필자가 어떠한 선택을 할 수 있는지 여러분이 제시해 주기 바란다.
 *
 * 4.두 개의 정수를 입력받아서 최대 공약수(GCD)를 구하는 프로그램을 작성해 보자.
 *
 * 5.  방정식 의 모든 해를 구하시오 단 와 는 정수이고 각각의 범위는 2x+4y=10 . , x y
 * 0<=x<=10, 0<=y<=10 .
 */
public class Quiz1 {
    static boolean[][][] p3_visited = new boolean[10][10][10];
    static boolean[][] p5_visited = new boolean[11][11];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = problem1(n);
        System.out.println(res);

        n = sc.nextInt();
        problem2(n);

        int balance = 3500;
        problem3(balance, 0, 0, 0);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        res = n1 < n2 ? problem4(n2, n1) : problem4(n1, n2);
        System.out.println(res);

        problem5(0, 0);
    }

    private static void problem5(int x, int y) {
        if(x > 10 || y > 10) return;
        if(p5_visited[x][y]) return;
        if(2 * x + 4 * y == 10) {
            p5_visited[x][y] = true;
            System.out.println("x = " + x + ", y = " + y);
            return;
        }

        problem5(x + 1, y);
        problem5(x, y + 1);

//        for (int i = 0; i <= 10; i++) {
//            for(int j = 0; j <= 10; j++) {
//                if((2 * i) + (4 * j) == 10) {
//                    System.out.println("x = " + i + " y = " + j);
//                }
//            }
//        }
    }

    private static int problem4(int n1, int n2) {
        // 12 6
        // 1234612 1236
        // 18 12
        // 1 2 3  1 2 3
        //18 9 6 12 6 4
//        int n = 12;
//        for (int i = 1; i <= 12; i++) {
//            if (n % i == 0) {
//                System.out.println(i);
//            }
//        }

        int res = 0;
        while (n2 != 0) {
            res = n2;
            n2 = n1 % n2;
        }
        return res;
    }

    private static void problem3(int balance, int a, int b, int c) {
        if(p3_visited[a][b][c]) return;
        if(balance < 0) return;
        if(balance == 0) {
            if(a > 0 && b > 0 && c > 0) {
                p3_visited[a][b][c] = true;
                System.out.println("크림빵 " + a + " 새우깡 " + b + " 콜라 " + c);
            }
            return;
        }
        problem3(balance - 500, a + 1, b, c);
        problem3(balance - 700, a, b + 1, c);
        problem3(balance - 400, a, b, c + 1);

//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                for (int k = 1; k < 10; k++) {
//                    if ((i * 500) + (j * 700) + (k * 400) == 3500) {
//                        System.out.println(i + " " + j + " " + k);
//                    }
//                }
//            }
//        }
    }

    private static void problem2(int n) {
        // 365초
        //
        int hour = n / (60 * 60);
        int minute = n / 60 % 60;
        int second = n % 60;

        System.out.println(hour + "시 " + minute + "분 " + second + "초");
    }

    private static int problem1(int n) {
        if(n == 0) {
            return 1;
        }
        return 2 * problem1(n - 1);
    }
}
