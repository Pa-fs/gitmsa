package ex03;

import java.util.Scanner;

public class Ex05 {
    /*
  1. 가위 바위 보 게임을 만들어 보자.

    사용자로부터 가위 바위 보 중에서 하나를 입력 받는다.
    그리고 컴퓨터는 난수 생성을 통해서 가위 바위 보 중에서 하나를 선택하게 한다.
     이 둘을 비교해서 승자와 패자를 가려주는 프로그램을 작성해 보자.
    단 프로그램의 진행은 사용자가 질 때까지 계속되어야 하고,
    마지막에 가서는 게임의 결과(예: 4승 3무)까지 출력해 주도록 하자.

    사용자   컴
    1 가위 2 바위 3 보
    1      2  = -1
    가위 < 바위  = lose
    2      3  = -1
    바위 <  보  = lose
    3      1  = 2
    보  > 가위  = lose

    1      3  = -2
    가위    보  = win
    3      2  = 1
    보    바위  = win
    2      1  = 1
    바위   가위 = win
     */
    static int win = 0, draw = 0, n = 0;
    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        boolean userDefeat = false;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            n = userValue(str);

            int com = (int)(Math.random() * 3 + 1);
            System.out.println("computer = " + (com == 1 ? "scissor" : com == 2 ? "rock" : "paper"));
            userDefeat = RockAndScissors(n, com);
            if(!userDefeat) {
                System.out.println("Your lose!!!");
                System.out.println("Total score : win = " + win + " draw = " + draw);
                break;
            }
        }
    }

    private static int userValue(String str) {
        int n = 0;
        switch (str) {
            case "가위":
                n = 1;
                break;
            case "바위":
                n = 2;
                break;
            case "보":
                n = 3;
                break;
            default:
        }
        return n;
    }

    private static boolean RockAndScissors(int user, int com) {
        int diff = user - com;
        if(diff == -1 || diff == 2) {
            return false;
        } else if(diff == 0) {
            System.out.println("draw!!!");
            draw++;
        } else {
            System.out.println("Your win!!!");
            win++;
        }
        return true;
    }

}
