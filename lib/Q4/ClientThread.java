package Q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    Socket socket;
    int indexClient;

    ClientThread(Socket socket, int indexClient) {
        this.socket = socket;
        this.indexClient = indexClient;
    }

    @Override
    public void run() {
        try {

            // !.....Envoi
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println("Client number :" + indexClient);
            System.out.println("Sent done for client #" + indexClient + "#\n");

            // !....Lecture
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            System.out.println("the received value is :" + s);

            // !.....Envoi
            System.out.println("Waiting for the string from client #" + indexClient + "#");
            os = socket.getOutputStream();
            pw = new PrintWriter(os, true);
            System.out.println("the string after treatment : " + s.toUpperCase());
            pw.println(s.toUpperCase());
            System.out.println("sent done for client #" + indexClient + "#");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
