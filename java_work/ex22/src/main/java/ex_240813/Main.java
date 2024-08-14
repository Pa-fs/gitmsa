package ex_240813;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Person[] parr = {
                new Person("나다라", 20),
                new Person("가가나라", 30),
                new Person("가나다라", 40),
                new Person("가나다", 40),
                new Person("가가나", 50),
                new Person("가가나", 40),
                new Person("가가나", 30),
        };

        Arrays.sort(parr);

        for (Person p : parr) {
            System.out.println(p);
        }
    }
}
