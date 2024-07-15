package ex07;

public class Quiz3 {

    /*
        3. 다음은 answer 배열 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 ‘*’을 찍어서
        그래프를 그리는 프로그램이다 에 알맞은 코드를 넣어서 완성하시오 .
        int[] answer = { 1,4,4,3,1,4,4,2,1,3,2}
        실행결과
        1***
        2**
        3**
        4****
     */
    public static void main(String[] args) {
        int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
        for (int i = 0; i < 4; i++) {
            int num = i + 1;
            System.out.print(i+1);
            for (int j = 0; j < answer.length; j++) {
                if(num == answer[j]) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
