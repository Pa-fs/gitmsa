package aa.bb;

public class CC {

    /**
     * Test method
     */
    public static void doA() {
//        int value = (int) (Math.random() * 6 + 1);
//        System.out.println(value);
    }

    public static void main(String[] args) {
        int n1 = 12, n2 = 18;
        for (int i = 1; i <= n1; i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                System.out.println(i);
            }
        }
    }
}
