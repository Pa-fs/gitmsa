package example;

public class Ex01 {

    public static void main(String[] args) {

        // primitive
        int a = 20;
        // wrapper 클래스이기 때문에 객체, 함수 존재
        Integer b = Integer.valueOf(20);
        System.out.println(b.equals(a));

        // unboxing 래퍼클래스가 기본자료형 타입으로 자동 변환...
        a = b;


    }
}
