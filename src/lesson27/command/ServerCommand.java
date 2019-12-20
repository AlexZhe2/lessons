package lesson27.command;

// базовый класс для всех команд сервера
public abstract class ServerCommand {
    protected MessageServer messageServer;

    public ServerCommand(MessageServer messageServer) {
        this.messageServer = messageServer;
    }

    abstract public void execute();

    // фабричный метод
    static ServerCommand getCommand(String stringCommand, MessageServer server) {
        ServerCommand command = new DefaultCommand(server);
        if ("time".equals(stringCommand)) {
            command = new TimeCommand(server);
        } else if ("connections".equals(stringCommand)) {
            command = new ConnectionsCountCommand(server);
        }
        return command;
    }
}
