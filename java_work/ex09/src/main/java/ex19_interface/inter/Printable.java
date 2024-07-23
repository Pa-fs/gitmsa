package ex19_interface.inter;

public interface Printable {

    // 인터페이스 안에서 변수는
    // 자동으로 static final 변수를 대문자로 지어짐
    int HEIGHT = 70;
    int WIDTH = 120;

    void print(String mydoc);

    default void clean() {
        System.out.println("청소기능 추가");
    }

    static void printLine() {
        System.out.println("한줄 출력할 때 줄바꿈");
    }
}
