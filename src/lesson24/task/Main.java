package lesson24.task;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        boolean work = true;
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите команду");
        while (work) {
            String user = in.nextLine();
            if ("help".equals(user)) {
                pool.execute(new Help());
            } else if ("time".equals(user)) {
                pool.execute(new Time());
            } else if ("getFromFile".equals(user)) {
                pool.execute(new GetFromFile());
            } else if ("exit".equals(user)){
                pool.shutdown();
                work = false;
            }
        }
    }
}
