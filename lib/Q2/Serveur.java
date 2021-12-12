package Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Side");
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server en action\n");

        System.out.println("Waiting for connection with client...");
        Socket sock = ss.accept();
        System.out.println("connected with client\n");

        InputStream is = sock.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println("the received value is :"+s);


        System.out.println("Waiting for the string");
        OutputStream os = sock.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        System.out.println("the string after treatment : "+s.toUpperCase());
        pw.println(s.toUpperCase());
        System.out.println("sent done");


        ss.close();
    }
}
