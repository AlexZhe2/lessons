package lesson26.decorator;

import java.time.LocalDateTime;

//class S implements Runnable {}
//class S extends Thread {}
//class S implements Callable<> {}

public class DecoratorPattern {
    public static void main(String[] args) {

      //  while (true) {
            // time sleep(1000) текущее время
            // help sleep(1000) список доступных команд
            // getFromFile sleep(1000) получение данных из файла
            // exit выход
       // }


        ILogger logger = new Logger();
        logger.write("log info");

        ILogger dateLogger = new DateLogger(logger);
        dateLogger.write("log info");

        ILogger codeLogger = new CodeLogger(new DateLogger(new Logger()));
        codeLogger.write("log info");
//        codeLogger.writeCode();

//        CodeLogger cd = new CodeLogger(new Logger());
//        cd.writeCode("hello");
    }
}

interface ILogger {
    void write(String data);
}

// класс с основным функционалом
class Logger implements ILogger {

    @Override
    public void write(String data) {
        System.out.println(data); // log info 0.31058440874503557 date: 2019-12-18T20:11:30.438

    }
}

// базовый декоратор
class LoggerDecorator implements ILogger {
    private ILogger logger;

    public LoggerDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void write(String data) {
        logger.write(data);
    }
}

// конкретные декораторы
class DateLogger extends LoggerDecorator {

    public DateLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData = data + " date: " + LocalDateTime.now();
        super.write(newData); // log info 0.31058440874503557 date: 2019-12-18T20:11:30.438
    }
}

class CodeLogger extends LoggerDecorator{

    public CodeLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData = data + " " + Math.random();
        super.write(newData); // log info 0.31058440874503557
    }

    public void writeCode(String data) {}
}












