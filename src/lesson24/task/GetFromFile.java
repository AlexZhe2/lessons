package lesson24.task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GetFromFile implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Files.readAllLines(new File("file.txt").toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
