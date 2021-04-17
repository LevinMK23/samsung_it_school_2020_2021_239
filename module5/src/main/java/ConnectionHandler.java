import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    private Server server;
    private Socket socket;
    private DataInputStream is;
    private DataOutputStream os;

    public ConnectionHandler(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public void sendMessage(String message) {
        try {
            os.writeUTF(message);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = is.readUTF();
                System.out.println("received: " + message);
                server.broadCastMessage(message);
                if (message.equals("/quit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
