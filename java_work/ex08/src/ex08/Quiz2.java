package ex08;

import ex08.quiz2.TV;
/*
2. 자바 클래스를 작성하는 연습을 해보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.

    public static void main(String[] args) {
        //LG에서 만든 2017년 32인치
        TV myTV = new TV("LG", 2017, 32);
        myTV.show();
    }

    출력
    LG에서 만든 2017년형 32인치 TV
 */
public class Quiz2 {

    public static void main(String[] args) {
        TV myTv = new TV("LG", 2017, 32);
        myTv.show();
    }
}
