package Q1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client Side");

        System.out.println("Waiting for connection");
        Socket s = new Socket("localhost", 1234);
        System.out.println("Connected");

        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number :");
            int i = sc.nextInt();

            os.write(i);
            System.out.println("\nNumber sent");

            System.out.println("Waiting for response");
            int rep = is.read();
            System.out.println("Response received :" + rep);

            //sc.close();
        }

        //s.close();
    }
}