package ex04;

/*
2. 피보나치 수열 은 앞을 두 수를 더해서 다음 수를 만들어 나가는 수열이다

    예를 들어 앞의 두 수가 1과 1이라면 그 다음 수는 2가 되고 그 다음 수는 1과 2를 더해서 3이 된다.
    0,1,1,2,3,5,8,13,21,... 이렇게 진행된다

    9 : 34
    10 : 55
    11 : 89
    피보나치수열의 10 번째 수는 무엇인지 계산하는 프로그램을 완성하시오

    3. 구구단의 일부분을 다음과 같이 출력하시오
    2*1=2       3*1=3       4*1=4
    2*2=4       3*2=6       4*2=8
    2*3=6       3*3=9       4*3=12

    5*1=5       6*1=6       7*1=7
    5*2=10      6*2=12      7*2=14
    5*3=15      6*3=18      7*3=21

    8*1=8       9*1=9
    8*2=16      9*2=18
    8*3=24      9*3=27

    i = 2, i < 10, i+=3
    j = 1, j < 4
    k = i, k < i + 3
    3 2 3 4
    3 5 6 7
    3 8 9
 */

public class Quiz1 {

    public static void main(String[] args) {
        System.out.println(fibo(10));
        gugudan();
    }

    private static void gugudan() {
        for (int k = 0; k < 9; k+=3) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 2; j <= 4; j++) {
                    if((j + k) == 10) break;
                    System.out.print((j + k) + "*" + i + "=" + ((j+k)*i) + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static int fibo(int n) {
        int prev = 0;
        int curr = 1;
        int res = 0;
        for (int i = 2; i <= 10; i++) {
            res = prev + curr;
            prev = curr;
            curr = res;
        }
        return res;
    }
}
