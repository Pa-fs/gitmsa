package ex01;

public class BankAccount {
    int a = 10;

    public void doA() {
        a = 20;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "a=" + a +
                '}';
    }
}
