import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Server {

    private ConcurrentLinkedDeque<ConnectionHandler> clients;

    private Server() throws IOException {

        clients = new ConcurrentLinkedDeque<>();

        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client accepted!");
            ConnectionHandler handler = new ConnectionHandler(this, socket);
            clients.add(handler);
            new Thread(handler).start();
        }
    }

    public ConcurrentLinkedDeque<ConnectionHandler> getClients() {
        return clients;
    }

    public void broadCastMessage(String message) {
        for (ConnectionHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) throws IOException {

        new Server();

    }

}
