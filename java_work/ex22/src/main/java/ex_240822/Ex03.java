package ex_240822;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex03 {

    interface AA {
        public void doA();
    }

    public static void main(String[] args) {
        AA aa = new AA() {
            @Override
            public void doA() {
                System.out.println("ㅇㅇ");
            }
        };


        List<Car> list = Arrays.asList(
                new Car("그랜저", 3000),
                new Car("K8", 3500),
                new Car("쏘렌토", 2200)
        );

        for (Car car : list) {
            System.out.println(car);
        }

//        Collections.sort(list, new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                return o1.getDisp() - o2.getDisp();
//            }
//        });

//        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(list, ( (o1, o2) -> o1.getName().length() - o2.getName().length() ) );

        System.out.println(" After sorting");

        for (Car car : list) {
            System.out.println(car);
        }
    }
}
