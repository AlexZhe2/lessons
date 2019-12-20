package lesson27.command;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    private int port;
    private Connection connection;

    public MessageServer(int port){
        this.port = port;
    }

    public Connection getConnection() {
        return connection;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                String clientCommand = connection.readMessage().getText();
                System.out.println(clientCommand);
                if ("time".equals(clientCommand)) {
                    executeCommand(new TimeCommand(this));
                }
//                printMessage(connection.readMessage());
//                connection.sendMessage(new Message("server", "сообщение получено"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void printMessage(Message message){
        System.out.println("получено сообщение: " + message);
    }

    public void executeCommand(ServerCommand command) {
        command.execute();
    }

    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}