package ex17.phone;

public class SmartPhone extends MobilePhone {

    private String androidVer;

    public SmartPhone(String androidVer, int number) {
        super(number);
        this.androidVer = androidVer;
    }

    public void show() {
        System.out.println("androidVer = " + androidVer);
    }
}
