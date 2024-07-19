package ex17.phone;

public class MobilePhone {

    protected int number;

    public MobilePhone(int number) {
        this.number = number;
    }
    
    public void show() {
        System.out.println("number = " + number);
    }
}
