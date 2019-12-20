package lesson27.command;

import java.io.IOException;
import java.time.LocalTime;

public class TimeCommand extends ServerCommand {
    public TimeCommand(MessageServer messageServer) {
        super(messageServer);
    }

    @Override
    public void execute() {
        // время
        try {
            messageServer.getConnection()
                    .sendMessage(new Message("server", LocalTime.now().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
