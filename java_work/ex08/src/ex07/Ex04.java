package ex07;

public class Ex04 {

    public static void main(String[] args) {
        Circle circle1 = new Circle(3);
        Circle circle2 = new Circle();

        circle1.setRad(100);
        circle1.setName("");
        System.out.println(circle1.getRad());
        System.out.println(circle1.getName());

        int rad = circle1.getRad();
        System.out.println(rad);
    }
}