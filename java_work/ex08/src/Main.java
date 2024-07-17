import java.util.Scanner;

class SmartPhone {

    private String color;
    private boolean power;

    public SmartPhone(String color) {
        this.color = color;
    }

    public void turnOn() {
        this.power = true;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
}


public class Main {

    public static void main(String[] args) {
        SmartPhone s = new SmartPhone("Sliver");
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        scanner.nextLine(); // 버퍼 비우는 코드
        String str = scanner.nextLine();

        System.out.println(a);
        System.out.println(str.isEmpty());
    }
}
