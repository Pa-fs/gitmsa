package ex_240826;

interface Printable {
    void print();
}

class Print1 implements Printable {
    @Override
    public void print() {
        System.out.println("...??");
    }
}

public class Printer {

    public static void main(String[] args) {

        //1. class 상속받아서..하는방법
        //2. 익명 인터페이스
        Printable print = () -> System.out.println("익명 인터페이스");

        Printable printLambda = () -> System.out.println("람다");
        printLambda.print();
    }
}
