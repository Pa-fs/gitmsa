package Ex06;

public class Quiz2 {

    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            sum = sum + n;
        }
        System.out.println(sum);
    }
}
