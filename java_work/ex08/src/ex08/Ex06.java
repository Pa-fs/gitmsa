package ex08;

class Test {
    public static void doA() {
        System.out.println("static doA");
    }

    public void doB() {
        System.out.println("just instance doB");
    }
}

public class Ex06 {
    // static method 에서 non-static 변수를 참조불가
    // num 이란 변수가 컴파일 시 메모리상에서 보이지 않음
//    int num = 0;
//    static void Add(int n) {
//        num += n;
//    }

    public static void main(String[] args) {
        Test.doA();
        Test test = new Test();
        test.doB();
    }
}
