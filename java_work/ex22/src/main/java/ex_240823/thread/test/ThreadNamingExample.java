package ex_240823.thread.test;

public class ThreadNamingExample {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(() -> {
            System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
        }, "myThread");
        myThread.start();

        Thread yourThread = new Thread(() -> {
            System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
        }, "yourThread");
        yourThread.start();

        for (int i = 0; i < 5; i++) {
            Thread defaultThread = new Thread(() -> {
                System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
            });
            defaultThread.start();
        }

        Thread.sleep(2000);
    }
}
