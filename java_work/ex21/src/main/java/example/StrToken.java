package example;

import java.util.StringTokenizer;

public class StrToken {

    public static void main(String[] args) {
//        Random random = new Random();
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(1000));
//        }

        StringTokenizer st = new StringTokenizer("PM:08:45", ":");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }
}
