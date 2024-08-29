package ex_240823.lambda;

// interface 꼭 한 개의 메서드가 있어야 한다
interface AA {
    void doA();

    default void doB() {
        System.out.println("doB");
    }

    static void doC() {
        System.out.println("doC");
    }
}

public class Ex04 {

    public static void doMethod(AA aa) {
        aa.doA();
        aa.doB();
        AA.doC();
    }

    public static void main(String[] args) {
        AA aa = () -> System.out.println("doA 메서드 재정의");
        aa.doA();

        // 메서드 호출하며 동시에 재정의 후 출력
        doMethod(() -> {
            System.out.println("doA 메서드를 이 메서드로 재정의");
            System.out.println("메서드 호출하며 동시에 재정의 후 출력");
        });
    }
}
