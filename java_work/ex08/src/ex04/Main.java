package ex04;

public class Main {

    public static void main(String[] args) {
        CalSecond calSecond = new CalSecond();

        int retValue = calSecond.inputNumber();
        System.out.println(retValue);

        String resultValue = calSecond.calculate(retValue);
        System.out.println(resultValue);
    }
}
