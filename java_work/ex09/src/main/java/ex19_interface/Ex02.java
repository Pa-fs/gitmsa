package ex19_interface;

import ex19_interface.inter.Printable;

public class Ex02 {

    public static void main(String[] args) {
        // 람다를 사용하려면 인터페이스에서 재정의해야할 메서드 하나만 필요함
        Printable printable = new Printable() {
            @Override
            public void print(String mydoc) {
                System.out.println("test " + mydoc);
            }
        };

        Printable printable1 = (str) -> {
            System.out.println("람다로 문서 출력 " + str);
        };
        printable1.print("//// 매개변수");
    }
}
