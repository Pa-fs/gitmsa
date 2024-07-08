package ex01;

public class Ex05 {
    public static int fact(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void go(int lev, String str) {
        if(lev == 0) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < 26; i++) {
            go(lev - 1, str + (char)(i + 'a'));
        }
    }
    public static void main(String[] args) {
        System.out.println(fact(5));
//        for (int i = 1; i <= 3; i++) {
//            go(i, "");
//        }
    }
}
