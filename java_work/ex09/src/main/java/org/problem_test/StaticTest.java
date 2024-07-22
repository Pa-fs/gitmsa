package org.problem_test;

class A {
    static int a;
    static String str;

    public static void print() {
        System.out.println("A = " + str);
    }
}

class B {

    public static void change() {
        A.str = "abcd";
        System.out.println("B = " + A.str);
    }
}

public class StaticTest {
    public static void main(String[] args) {

        System.out.println(A.str);

        B.change();
        A.print();
    }
}
