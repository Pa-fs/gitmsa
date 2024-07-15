package ex06;

public class Box {
    String name;
    int count;

    /*
    기본생성자 생략가능 하지만
    다른생성자 선언할 시 기본생성자 생략 불가
     */
    public Box() {
        System.out.println("기본생성자 호출");
    }
    public Box(String n) {
        name = n;
        System.out.println("다른생성자 호출");
    }
    public Box(String n, int c) {
        name = n;
        count = c;
        System.out.println("다른 생성자 호출");
    }

    // 객체 출력 시 내부적으로 주소 출력 (생략되어짐)
    // 오버라이딩
    public String toString() {
        return "name = " + name + " count = " + count;
    }

    // 메서드 이름이 동일할 수 없다
    public void doA(){}
    public void doA(String a){}
}
