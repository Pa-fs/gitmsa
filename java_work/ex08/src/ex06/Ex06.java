package ex06;
class A {
    String name;
}
public class Ex06 {

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        int[] br = ar;

        br[0] = 10;

        for (int j : ar) {
            System.out.println(j);
        }
        System.out.println();
        for (int j : br) {
            System.out.println(j);
        }

        A a = new A();
        A b = a;
        a.name = "홍길동";
        System.out.println("a.name = " + a.name);
        System.out.println("b.name = " + b.name);
    }
}
