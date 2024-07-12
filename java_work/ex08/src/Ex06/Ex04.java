package Ex06;

public class Ex04 {
    // 기본 생성자
    // toString()
    Ex04() {
        System.out.println("기본생성자");

        int[] ar = {10,20,30,40,50};
        doA(ar);
        int[] br = makeary(10);
        System.out.println("br.length() = " + br.length);
    }

    private int[] makeary(int len) {
        return new int[len];
    }

    public void doA(int[] qw) {
        int sum = 0;
        for (int i = 0; i < qw.length; i++) {
            sum = sum + qw[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Ex04 ex04 = new Ex04();

        System.out.println(ex04);
    }
}
