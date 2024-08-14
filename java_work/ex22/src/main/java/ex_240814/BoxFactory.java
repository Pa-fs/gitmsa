package ex_240814;

public class BoxFactory {

    // 두 메서드 역할이 같다
    // peekBox / peekBox2
    public static <T> void peekBox(Box<T> box) {
        System.out.println(box);
    }

    public static void peekBox2(Box<?> box) {
        System.out.println(box);
    }

    // Object의 경우 되지 않음
    public static void peekBox3(Box<Object> box) {
        System.out.println(box);
    }

    // 상한 제한
    public static void peekBox4(Box<? extends AA> box) {
        System.out.println(box);
    }

    // 하한 제한
    public static void peekBox5(Box<? super BB> box) {
        System.out.println(box);
    }

    // ? extends [OBJECT] 이면 OBJECT에 getter만 사용가능
//    public static void peekBox6(Box<? extends AA> box) {
//        AA getBox = box.getT();
//        System.out.println(getBox);
//        box.setT(new AA());
//    }

    public static void peekBox7(Box<AA> box) {
        AA getBox = box.getT();
        System.out.println(getBox);
        box.setT(new AA());
    }

    public static <T> T getMyBox(Box<? extends T> box) {
        return box.getT();
    }
}
