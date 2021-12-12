package Q1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Side");
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server en action\n");

        System.out.println("waiting for connection with client");
        Socket s = ss.accept();
        System.out.println("Connected with client\n");

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        while (true) {
            System.out.println("waiting for the number");
            int nb = is.read();
            System.out.println("Number received : " + nb + "\n");
            int rep = nb * 2;
            System.out.println("Number after treatment : " + rep + "\n");
            os.write(rep);
            System.out.println("Sent done");
        }

        // ss.close();
    }
}
