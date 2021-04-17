import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8189);
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        Scanner in = new Scanner(System.in);

        new Thread(() -> {
            try {
                while (true) {
                    String message = is.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.err.println("Connection was broken");
            }
        }).start();

        while (true) {
            String s = in.nextLine();
            os.writeUTF(s);
            os.flush();
        }
    }
}
