package lesson26.decorator;

import java.time.LocalDateTime;

public class DecoratorPattern {
    public static void main(String[] args) {
        ILogger logger = new Logger();
        logger.write("log info");
        
        ILogger dateLogger = new DateLogger(logger);
        dateLogger.write("log info");

        ILogger codeLogger = new CodeLogger(new DateLogger(new Logger()));
        codeLogger.write("log info");
    }
}

interface ILogger {
    void write(String data);
}

class Logger implements ILogger {

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}

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

class DateLogger extends LoggerDecorator {

    public DateLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String newData = data + " date: " + LocalDateTime.now();
        super.write(newData);
    }
}




