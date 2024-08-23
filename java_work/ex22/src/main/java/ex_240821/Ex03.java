package ex_240821;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex03 {

    public static void main(String[] args) {

//        Comparator<Person> comparator = new Comparator<>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        };

        TreeSet<Person> treeSet = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());

        Person p1 = new Person(30, "abcd");
        Person p2 = new Person(31, "bcd");
        Person p3 = new Person(32, "bcdf");

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);

        System.out.println(treeSet);
    }
}
