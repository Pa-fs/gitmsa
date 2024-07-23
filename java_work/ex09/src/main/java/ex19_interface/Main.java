package ex19_interface;

import ex19_interface.inter.CMYKPrintable;
import ex19_interface.inter.Printable;
import ex19_interface.print.CMYKPrinter;
import ex19_interface.print.LGPrinter;
import ex19_interface.print.SamPrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println(Printable.HEIGHT);
        System.out.println(Printable.WIDTH);

        // final 예약어가 붙어 있어서 아래의 값의 변경이 불가능하다..
//        Printable.HEIGHT = 90;

        Printable printable = new LGPrinter();
        printable.print("내 문서");

        printable = new SamPrinter();
        printable.print("내문서");

        CMYKPrintable cmykPrinter = new CMYKPrinter();
        cmykPrinter.printCMYK("내 문서");

        printable.clean();
        Printable.printLine();

        // 인터페이스 유지보수 입장에서 생각
        // PolicyCustomer interface policy
        // 일반 고객, VIP 고객은 어떤 개인제품 각각 10%, 20% 할인
        // policy = new EachProductPercentDiscount();
        // 정책 변경 => 주문 총합에서 몇% 할인
        // policy = new AllProductPercentDiscount();
        // 객체(new)만 갈아끼우면 됨
        // 다른 예) 사용하던 데이터베이스를 다른 데이터베이스로 변경한다

        // 상속의 경우도 가능하지만
        // 상속의 단점 : 상속이 깊어지면 부모, 조상 변수가 안보임
        // 버그 발생 엄청 높음
        // 중요한 점은 인터페이스는 변수 자체를 신경쓰지 않기 때문에
        // 더 자유로움
        // 상위에서 정보를 더 많이 알수록 관리를 해줘야할 게 늘어난다
        // 추상화 <-> 구체화
    }
}
