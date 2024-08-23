package ex_240822.thread;

public class BasicJoinExample {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                System.out.println("1초마다 작업 수행");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("thread1 작업 중");
                }
            } catch (InterruptedException e) {
                mainThread.interrupt();
                System.out.println("thread 인터럽트됨");
            }
        });

        thread.start();

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread1에서 인터럽트 시도");
                thread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();

        try {
            System.out.println("메인 스레드 작업 시작");
            thread.join();
            System.out.println("메인 스레드 작업 종료");
        } catch (InterruptedException e) {
            System.out.println("메인 스레드 인터럽트됨");
        }

    }
}
