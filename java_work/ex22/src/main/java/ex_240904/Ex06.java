package ex_240904;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex06 {

    public static final List<Integer> list =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 16; i++) {
            list.add(i);
        }

        System.out.println(list);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 동기화의 문제가 된다
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                ListIterator<Integer> itr = list.listIterator();
                while (itr.hasNext()) {
                    itr.set(itr.next() + 1);
                }
            });
        }

//        executorService.submit(() -> {
//            for (int i = 0; i < 16; i++) {
//                list.set(i, list.get(i) + 1);
//            }
//        });
//        executorService.submit(() -> {
//            for (int i = 0; i < 16; i++) {
//                list.set(i, list.get(i) + 1);
//            }
//        });
//        executorService.submit(() -> {
//            for (int i = 0; i < 16; i++) {
//                list.set(i, list.get(i) + 1);
//            }
//        });

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(list);
    }
}
