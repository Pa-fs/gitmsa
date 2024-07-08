package ex01;

public class Ex06 {

    public static void main(String[] args) {
        Box box1 = new Box();
        Box box2 = new Box();

        System.out.println(box1);
        System.out.println(box2);

        box1.setName("사과");
        box2.setName("수박");
        System.out.println(box1);
        System.out.println(box2);
    }
}
