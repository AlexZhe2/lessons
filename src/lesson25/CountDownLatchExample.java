package lesson25;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    static final CountDownLatch CDL = new CountDownLatch(6);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new SomeThread()).start();
        }

        while (CDL.getCount() > 3){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
            System.out.println("Событие 1");
            CDL.countDown();

            Thread.sleep(500);
            System.out.println("Событие 2");
            CDL.countDown();

            Thread.sleep(500);
            System.out.println("Событие 3");
            CDL.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class SomeThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName());
            CDL.countDown();
            try {
                CDL.await();
                System.out.println("Завершение работы " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
