package ex03;

public class Ex01 {

    private static int add() {
        return 10;
    }


    private static int add(int num) {
        System.out.println("num add= " + num);
        return 10;
    }


    public static void main(String[] args) {
        int result = add(10);
        System.out.println("result = " + result);
    }

}
