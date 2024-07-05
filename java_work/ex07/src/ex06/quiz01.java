package ex06;
/**
 * 1. 두 개의 주사위 던졌을때, 눈의 합이 6이 되는 모든 경우의 수
 * 출력하는 프로그램 작성
 * 2. Math.random을 이용해서 1부터 6사이의
 * 임의의 정수를 변수 value에 저장하는 코드를 완성
 * (1) 에 알맞은 코드를 넣으세여
 */
public class quiz01 {

    public static void main(String[] args) {
        problem01();
        System.out.println(problem02());
    }

    private static int problem02() {
        // 0 <= random < 1
        // random * 10 => 0 <= random < 10
        // random + 1 => 1 <= random < 7

        for (int i = 0; i < 100; i++) {
            int value = (int) (Math.random() * 6 + 1);
            System.out.println("value = " + value);
        }
        return 0;
    }

    private static void problem01() {
        for (int i = 1; i <= 6; i++) {
            for(int j = 1; j <= 6; j++) {
                if(i + j == 6) {
                    System.out.print("i + j == 6 " + "(" + i +" , " + j + ")");
                }
            }
            System.out.println();
        }
    }
}