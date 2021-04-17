import java.io.*;
import java.net.Socket;

public class NetExample {

    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("video.mp4");
//        FileOutputStream fos = new FileOutputStream("stream.mp4");
//
//        byte[] buffer = new byte[1024];
//
//        for (int i = 0; i < 3000; i++) {
//            int read = fis.read(buffer);
//            fos.write(buffer, 0, read);
//        }
//        fos.close();

        Socket socket = new Socket("www.vk.com", 80);

        String query = "GET / HTTP/1.1\n" +
                "       Host: https://vk.com";

        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());


        os.writeUTF(query);
        os.flush();

        System.out.println("1");

        byte[] buffer = new byte[1024];

        int read = is.read(buffer);

        System.out.println(new String(buffer, 0, read));

    }

}
