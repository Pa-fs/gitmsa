package ex08;
// 모든 곳에서 참조하고 싶을 때
// public static String dbUrl = "";

class InstClass {
    static int num = 0;

    InstClass() {
        num++;
        System.out.println(num);
    }
}

public class Ex04 {

    public static void main(String[] args) {
        System.out.println(InstClass.num);
        InstClass instClass1 = new InstClass();
        InstClass instClass2 = new InstClass();
        InstClass instClass3 = new InstClass();
        InstClass instClass4 = new InstClass();

        System.out.println(InstClass.num);
    }
}
