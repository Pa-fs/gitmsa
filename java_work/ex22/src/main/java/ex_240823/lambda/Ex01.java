package ex_240823.lambda;

class Outer {
    static int num = 0;

    class Member {
        void add(int n) {
            num += n;
        }

        int get() {
            return num;
        }
    }
}

class Exterior {
    void plusStaticVariable() {
        Outer.num++;
    }
}

public class Ex01 {

    public static void main(String[] args) {

        Outer outer1 = new Outer();
        Outer outer2 = new Outer();

        Outer.Member o1m1 = outer1.new Member();
        o1m1.add(5);

        Outer.Member o1m2 = outer2.new Member();
        o1m2.add(7);

        System.out.println(o1m1.get());
        System.out.println(o1m2.get());
    }
}
