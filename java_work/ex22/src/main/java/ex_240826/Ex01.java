package ex_240826;

interface Calculate {
    void cal(int a, String b);
}

interface RETCAL {
    int cal(int a, int b);
}

public class Ex01 {
    public static void main(String[] args) {
        RETCAL rc = (a, b) -> {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            return a + b;
        };

        int res = rc.cal(10, 20);
        System.out.println(res);


//        Calculate c = (a, b) -> {
//            System.out.println("계산");
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);
//        };
//
//        c.cal(10, "문자열");
//
//        Calculate c2 = (a,b) -> {
//            System.out.println("람다 계산");
//        };
//
//        c2.cal(10, "람다");
//
//        c2 = (a, b) -> {
//            System.out.println("새로운 람다 계산");
//        };
//
//        c2.cal(20, "새로운 람다");
    }
}
