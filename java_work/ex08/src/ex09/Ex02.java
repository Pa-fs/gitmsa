package ex09;

public class Ex02 {

    // 오버로딩
    // 메서드,생성자 이름이 같지만 파라메터가 다를 때 사용가능하다
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("999999");
        Person p3 = new Person("999999", "000001");

        p1.show();
        p2.show();
        p3.show();
    }
}
