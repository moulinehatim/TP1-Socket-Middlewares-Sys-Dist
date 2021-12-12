package Q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client Side");

        System.out.println("Waiting for connection");
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String :");
        String ch = sc.next();

        OutputStream os = s.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println(ch) ;
        System.out.println("\nString sent\n");

        System.out.println("Waiting for response...");
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String response = br.readLine();
        System.out.println("The response is :"+response);

        sc.close();
        s.close();
    }
}