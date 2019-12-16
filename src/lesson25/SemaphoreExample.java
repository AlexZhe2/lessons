package lesson25;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
//        public Semaphore(int permits, boolean fair)


    }
}

class Counter {
    static int count = 0;
}

class IncrementThread implements Runnable {
    private Semaphore semaphore;

    public IncrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("начало работы потока Increment");
        try {
            semaphore.acquire();
            System.out.println("Increment получил разрешение");
            for (int i = 0; i < 8; i++) {
                Counter.count++;
                System.out.println("Increment Count = " + Counter.count);
//                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Increment отработал с общим ресурсом");
        semaphore.release();
    }
}

class DecrementThread implements Runnable {
    private Semaphore semaphore;

    public DecrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("начало работы Decrement");
        try {
            semaphore.acquire();
            System.out.println("Decrement получил разрешение");
            for (int i = 0; i < 8; i++) {
                Counter.count--;
                System.out.println("Decrement Count = " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Decrement отработал с общим ресурсом");
        semaphore.release();
    }
}



