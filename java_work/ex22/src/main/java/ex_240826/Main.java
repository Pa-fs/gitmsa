package ex_240826;

import java.util.*;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("ROBOT", "BOX", "LAMBDA", "AA", "기역");
        list = new ArrayList<>(list);

        System.out.println(list);

//        Collections.sort(list, (String a, String b) -> a.length() - b.length());
        MyComparator myComparator = new MyComparator();
        Collections.sort(list, myComparator);

        System.out.println(list);
    }
}
