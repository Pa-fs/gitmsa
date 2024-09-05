package ex_240904;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        thread.join();
        thread2.join();
        for (int i = 0; i < 1000; i++) {
            Thread th1 = Thread.currentThread();
            System.out.println(th1.getName() + " " + i);
        }
    }
}
