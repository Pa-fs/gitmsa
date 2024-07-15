package ex07;

/*
        2. int[][] arr = {
                { 5, 5, 5, 5, 5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };
        arr 배열을 총합과 평균을 구하는 프로그램을 작성하세요
 */
public class Quiz2 {
    public static void main(String[] args) {
        int[][] arr = {
                { 5, 5, 5, 5, 5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum = sum + arr[i][j];
            }
        }

        System.out.println(sum);
        System.out.println((int)(sum / (double)(arr.length * arr[0].length)));
    }
}
