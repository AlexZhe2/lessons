package lesson27.command;

import java.io.IOException;
import java.time.LocalTime;

public class ConnectionsCountCommand extends  ServerCommand {
    public ConnectionsCountCommand(MessageServer messageServer) {
        super(messageServer);
    }

    @Override
    public void execute() {
        try {
            messageServer.getConnection()
                    .sendMessage(new Message("server",
                            String.valueOf(messageServer.getCount())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
