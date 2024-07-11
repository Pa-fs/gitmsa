package ex05;

public class Ex05 {
    public static void main(String[] args) {
        String str = "a+b+c+";
        String[] tempStr = str.split("\\+");
        for (int i = 0; i < tempStr.length; i++) {
            System.out.print(tempStr[i]);
        }
        System.out.println();

        String a = "abcdefgh";
        System.out.println(a.length());

        System.out.println(a.charAt(0));
        System.out.println(a.charAt(1));
        System.out.println(a.charAt(2));
        System.out.println(a.charAt(3));

        System.out.println(a.substring(2));
        System.out.println(a.substring(2, 5));
        System.out.println(a.toUpperCase());
        System.out.println(a.replace('d', 'H'));

        System.out.println("배열출력시작");
        char[] test = a.toCharArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        System.out.println("배열출력끝");
        test[2] = 'A';
        String testStr = new String(test);
        System.out.println(testStr);

        int[] b = new int[3];
        System.out.println(b.length);
    }

}
