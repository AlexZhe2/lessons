package lesson27.command;

// базовый класс для всех команд сервера
public abstract class ServerCommand {
    protected MessageServer messageServer;

    public ServerCommand(MessageServer messageServer) {
        this.messageServer = messageServer;
    }

    abstract public void execute();
}
