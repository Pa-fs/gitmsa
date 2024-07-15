package ex06;

/*
1. 배열 [10,20,30,40,50] 알맞은 코드를 넣어 총합과 평균구하기
 */
public class Quiz1 {

    public static void main(String[] args) {
        int[] arr = {15,23,433,40,52};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        System.out.println("총합 = " + sum);
        System.out.println("평균 = " + (int)((sum / (double)arr.length)));
    }
}
