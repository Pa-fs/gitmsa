package ex_240904;

class Task extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                if(i % 2 == 0)
                    System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Ex02 {

    public static void main(String[] args) {
        Task t1 = new Task();
        t1.start();

        Task t2 = new Task();
        t2.start();
    }
}
