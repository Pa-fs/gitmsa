package bank;

import ex01.BankAccount;

public class BankAccountMain {

    public static void main(String[] args) {
        BankAccount park = new BankAccount("박길동", "1234", "850511", 5000);
        BankAccount yoon = new BankAccount("윤길동", "4567", "950511", 5000);
        BankAccount anonymous = new BankAccount();

//        park.initAccount("1234", "850511", 5000);
//        yoon.initAccount("4567", "950511", 5000);
        // 참조변수는 출력할 때 toString()은 생략가능하다
        // toString 은 내가 다시 정의할 수 있다.
        // 클래스는 주소값을 생성
        park.cmb();
        yoon.cmb();
        anonymous.cmb();

        park.deposit(3000);
        yoon.deposit(4000);

        park.cmb();
        yoon.cmb();

        park.withdraw(1000);
        yoon.withdraw(2000);

        park.cmb();
        yoon.cmb();

        System.out.println("끝");

    }
}
