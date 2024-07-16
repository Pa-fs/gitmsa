package ex08;
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
class TV {
    private String companyName;
    private int createdYear;
    private int size;

    public TV(String companyName, int createdYear, int size) {
        this.companyName = companyName;
        this.createdYear = createdYear;
        this.size = size;
    }

    public void show() {
        System.out.println(companyName + "에서 만든 " + createdYear +"년 " + size + "인치");
    }
}

public class Quiz2 {

    public static void main(String[] args) {
        TV myTv = new TV("LG", 2017, 32);
        myTv.show();
    }
}
