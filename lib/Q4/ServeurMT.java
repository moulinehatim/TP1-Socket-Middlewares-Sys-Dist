package Q4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {
    @Override
    public void run() {
        System.out.println("Server Side");
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server en action\n");
            int clientNumber=0;
            while (true) {
                clientNumber++;
                System.out.println("Waiting for connection with client "+clientNumber+"...");
                Socket sock = ss.accept();
                System.out.println("connected with client"+clientNumber+"\n");
                new ClientThread(sock,clientNumber).start();
            }

            // ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServeurMT().start();
    }
}
