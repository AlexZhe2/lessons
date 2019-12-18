package lesson24.task;

import java.time.LocalDateTime;

public class Time implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Date: " + LocalDateTime.now());
    }
}

