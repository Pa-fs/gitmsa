package ex01;

public class BankAccountMain {

    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();

        // 참조변수는 출력할 때 toString()은 생략가능하다
        // toString 은 내가 다시 정의할 수 있다.
        // 클래스는 주소값을 생성
        System.out.println(a);
        System.out.println(b);
        a.doA();
        System.out.println(a);
        System.out.println(b);
    }
}
